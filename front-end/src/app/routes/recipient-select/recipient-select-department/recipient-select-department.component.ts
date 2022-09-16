import { BehaviorSubject,  Subject } from 'rxjs';
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { cloneDeep as _cloneDeep, filter as _filter } from 'lodash';
import { sortBy as _sortBy } from 'lodash';
import { takeUntil } from 'rxjs/operators';

import { ApiResponseRecipientProfile, ApiResponseRecipientDetails } from '../../../interfaces/api-response-recipient-profile.interface';
import { BlockingIndicatorService } from '../../../services/blocking-indicator/blocking-indicator.service';
import { config } from '../../../config/config';
import { DataService } from '../../../services/data/data.service';
import { DialogHelpComponent } from '../../../components/dialog-help/dialog-help.component';
import { ManageFields } from '../../../classes/manage-fields';
import { RecipientService } from '../../../services/recipient/recipient.service';
import { SelectOption } from '../../../interfaces/select-option.interface';
import { SelectOptgroup} from '../../../interfaces/select-optgroup.interface';


@Component({
  selector: 'nsc-recipient-select-department',
  templateUrl: './recipient-select-department.component.html',
  styleUrls: ['./recipient-select-department.component.scss']
})
export class RecipientSelectDepartmentComponent implements OnDestroy, OnInit {
  @Input() formGroup: FormGroup;

  data = this.dataService.get();
  who = this.data.form.recipient.who;
  unsubscribe$ = new Subject();

  content = {
    // labels will be populated by an AJAX response;
    labelAamcAccountNumber: null,
    labelAmcasTranscriptIdNumber: null,
    labelCasId: null,
    labelDepartment: null,
    labelLsacAccountNumber: null,

    // department isn't always required, depends on the scenario;
    requireDepartment: null
  };

  masks = {
    aamcAccountNumber: [/\d/, /\d/, /\d/, /\d/, /\d/, /\d/, /\d/, /\d/],
    amcasTranscriptIdNumber: [/\d/, /\d/, /\d/, /\d/, /\d/, /\d/, /\d/],
    lsacAccountNumber: ['L', /\d/, /\d/, /\d/, /\d/, /\d/, /\d/, /\d/, /\d/]
  };

  values = {
    // SELECT values populated by service call;
    departments$: new BehaviorSubject(<any[]>[])
  };

  constructor (
    public blockingIndicatorService: BlockingIndicatorService,
    private dataService: DataService,
    public dialog: MatDialog,
    private manageFields: ManageFields,
    private recipientService: RecipientService
  ) {}

  ngOnInit () {
    this.processRecipientJson(this.who.recipientResponse);

    this.initDepartmentListener();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initDepartmentListener (): void {
    const controls = this.formGroup.controls;

    // wach the `department` field, and when it changes get the next questions ready;
    controls.department.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        if (value) {
          this.manageFields.disable([
            controls.amcasTranscriptIdNumber,
            controls.aamcAccountNumber,
            controls.casId,
            controls.departmentNotInList,
            controls.lsacAccountNumber
          ]);

          // enable the "not in list" field if we should;
          if (value.toString().toUpperCase() === config.values.autocomplete.notInList.name.toUpperCase()) {
            this.setDepartmentNotInList(true);
          }
        }
      });
  }

  getRecipient (ficeCode: string): void {
    const controls = this.formGroup.controls;

    this.blockingIndicatorService.open();

    this.recipientService.getData(ficeCode)
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: ApiResponseRecipientProfile) => {
        // disable the fields until we know we can show them;
        this.manageFields.disable([
          controls.amcasTranscriptIdNumber,
          controls.aamcAccountNumber,
          controls.casId,
          controls.department,
          controls.departmentNotInList,
          controls.lsacAccountNumber
        ]);

        controls.recipientResponse.setValue(null);

        // force a small delay;
        window.setTimeout(() => {
          this.processRecipientJson(json);

          // now that we're done processing the recipient details, hide the progress bar;
          this.blockingIndicatorService.close();
        }, config.values.loading.delay);
      });
  }

  saveRecipientJson (json: ApiResponseRecipientProfile): void {
    // record the response JSON so on edit we don't have to make an Ajax call to determine which fields to show;
    this.formGroup.controls.recipientResponse.setValue(json);
  }

  processRecipientJson (json: ApiResponseRecipientProfile): void {
    const controls = this.formGroup.controls;

    // might not be a response;
    // dont do anything if there isn't a saved response;
    if (json) {
      // if there is a response, make sure it is an electronic exchange (ETX) organization;
      if (json.exchangeNetworkType === 'ETX') {
        this.saveRecipientJson(json);

        // show AMACs form fields;
        if (json.subNetwork && json.subNetwork.deptName === 'AMCAS') {
          const profiles = json.subNetwork.eteIdProfiles || [];
          const aamcArray = _filter(profiles, { eteIdType: 'AMCAS_AAMC_ID' });
          const amcasArray = _filter(profiles, { eteIdType: 'AMCAS_TRANSCRIPT_ID' });

          if (aamcArray.length && amcasArray.length) {
            this.content.labelAamcAccountNumber = aamcArray[0].eteIdLabel.replace(':', '');
            this.content.labelAmcasTranscriptIdNumber = amcasArray[0].eteIdLabel.replace(':', '');

            this.manageFields.enable([
              controls.amcasTranscriptIdNumber,
              controls.aamcAccountNumber
            ]);
          } else {
            // do nothing if the labels weren't found;
          }

        // show LSAC form field;
        } else if (json.subNetwork && json.subNetwork.deptName === 'LSAC') {
          const profiles = json.subNetwork.eteIdProfiles || [];
          const lsacArray = _filter(profiles, { eteIdType: 'LSAC_ID' });

          if (lsacArray.length) {
            this.content.labelLsacAccountNumber = lsacArray[0].eteIdLabel.replace(':', '');

            this.manageFields.enable([
              controls.lsacAccountNumber
            ]);
          } else {
            // do nothing if the labels weren't found;
          }

        // show CAS form field;
        } else if (json.subNetwork && json.subNetwork.subNetworkType === 'LIAISON') {
          const profiles = json.subNetwork.eteIdProfiles || [];
          const lsonArray = _filter(profiles, { eteIdType: 'LIAISON_CAS_TRANSCRIPT_ID' });

          if (lsonArray.length) {
            this.content.labelCasId = lsonArray[0].eteIdLabel.replace(':', '');

            this.manageFields.enable([
              controls.casId
            ]);
          } else {
            // do nothing if the labels weren't found;
          }

        // show a SELECT form field of departments (if defined);
        } else if (json.recipientDepartments && json.recipientDepartments.length) {
          this.setDepartmentSelect(json.recipientDepartments);

        } else {
          this.setDepartmentNotInList(false);
        }
      // not an ETX network;
      } else {
        this.setDepartmentNotInList(false);
      }
    }
  }

  // on change of organization or school, we need to determine how to display the department fields;
  // pass in the control of the recipient (organization or school), and the possible values;
  // this will allow us to determine which department fields to show;
  changeRecipient (control, recipients): void {
    const archiveStudent = this.data.response.orderHeader.archiveStudent;
    const etxArchiveStudentIsValid = archiveStudent === null || archiveStudent === '' || archiveStudent === 'N';
    const etxSendToSchoolIsValid = ['F', 'P', 'B'].indexOf(this.data.schoolProfile.displaySendToSchoolOption) > -1;

    const value = control.value ? control.value.toUpperCase() : null;
    const isNotInList = value === config.values.select.notInList.value;

    // the following ETX criteria are met, then make an API call for departments for the selected recipient;
    if (etxArchiveStudentIsValid && etxSendToSchoolIsValid && !isNotInList) {
      const recipientsArray = _filter(recipients, { value: value });

      if (recipientsArray.length) {
        const ficeCode = recipientsArray[0].ficeCode;

        this.formGroup.patchValue({
          recipientFiceCode: ficeCode
        });

        this.getRecipient(ficeCode);
      }
    // if not an ETX school selection, show the optional department field;
    } else {
      this.setDepartmentNotInList(false);
    }
  }

  setDepartmentSelect (departments: ApiResponseRecipientDetails[]): void {
    const controls = this.formGroup.controls;

    if (departments.length) {
      // conver the departments into an object to insert into the SELECT;
      const newValue = departments.map((option: ApiResponseRecipientDetails) => {
        return {
          name: option.deptName,
          value: option.deptId
        };
      });

      // sort the or departments, then add the not in list so it's at the bottom;
      const sortedValues = _sortBy(newValue, 'name');
      sortedValues.push(config.values.select.notInList);

      // set the sorted value, then enable the form field;
      this.values.departments$.next(sortedValues);

      // only enable the control if it is disabled to not trigger a change event;
      if (controls.department.disabled) {
        this.manageFields.enable([
          controls.department
        ]);
      }
    }
  }

  setDepartmentNotInList (required: boolean): void {
    const controls = this.formGroup.controls;

    if (required) {
      this.content.labelDepartment = 'Enter a Department';
      this.content.requireDepartment = true;
      controls.departmentNotInList.clearValidators();
      controls.departmentNotInList.setValidators([ Validators.required, Validators.minLength(2) ]);
    } else {
      this.content.labelDepartment = 'Department Name';
      this.content.requireDepartment = false;
      controls.departmentNotInList.clearValidators();
      controls.departmentNotInList.setValidators([ Validators.minLength(2) ]);

      // because we know an optional department is shown, we know that the departments SELECT shouldn't be visible;
      this.manageFields.disable([
        controls.department
      ]);
    }

    if (controls.departmentNotInList.disabled) {
      this.manageFields.enable([
        controls.departmentNotInList
      ]);
    }
  }

  openDialog (): void {
    const dialogRef = this.dialog.open(DialogHelpComponent, {
      width: '480px',
      data: {
        title: 'Help',
        body: '<img src="/assets/liaison-barcode.png" alt="" /><br />Enter a value for the CAS Transcript ID field. The CAS Transcript ID can be found on the Transcript Request form generated by the admissions service. The number is under the bar code on the form. Please copy and paste the ID number into the ‘CAS Transcript ID’ field.'
      }
    });
  }
}
