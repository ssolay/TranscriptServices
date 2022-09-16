import { BehaviorSubject,  Subject } from 'rxjs';
import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { cloneDeep as _cloneDeep, filter as _filter } from 'lodash';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../../config/config';
import { DataService } from '../../../services/data/data.service';
import { ManageFields } from '../../../classes/manage-fields';
import { OrganizationsService } from '../../../services/organizations/organizations.service';
import { RecipientSelectDepartmentComponent } from '../recipient-select-department/recipient-select-department.component';
import { SelectOption } from '../../../interfaces/select-option.interface';


@Component({
  selector: 'nsc-recipient-select-organization',
  templateUrl: './recipient-select-organization.component.html',
  styleUrls: ['./recipient-select-organization.component.scss']
})
export class RecipientSelectOrganizationComponent implements OnDestroy, OnInit {
  @Input() formGroup: FormGroup;
  @ViewChild(RecipientSelectDepartmentComponent) recipientSelectDepartmentComponent: RecipientSelectDepartmentComponent;

  data = this.dataService.get(); // set to we dont have to call get() over and over again during init;
  who = this.data.form.recipient.who;
  unsubscribe$ = new Subject();

  values = {
    // SELECT values populated by service call;
    organizations$: new BehaviorSubject(<any[]>[])
  };

  constructor (
    private dataService: DataService,
    private manageFields: ManageFields,
    private organizationsService: OrganizationsService
  ) {}

  ngOnInit () {
    this.initServiceValues();
    this.initOrganizationListener();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initServiceValues (): void {
    this.organizationsService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: SelectOption[]) => {
        if (json.length) {
          // clone the response so we dont add the Not In List value to the service value;
          // if we do, multiple trips through this route will result in multiple Not In List options;
          const jsonClone = _cloneDeep(json);

          jsonClone.push(config.values.select.notInList);
          this.values.organizations$.next(jsonClone);
        }
      });
  }

  initOrganizationListener (): void {
    const controls = this.formGroup.controls;

    // wach the `organization` field, and when it changes get the next questions ready;
    controls.organization.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        if (value) {
          this.manageFields.disable([
            controls.amcasTranscriptIdNumber,
            controls.aamcAccountNumber,
            controls.casId,
            controls.department,
            controls.departmentNotInList,
            controls.lsacAccountNumber,
            controls.organizationNotInList
          ]);

          // null out any selected recipient;
          // this isn't a field visible to the user;
          // don't disable, just nullify;
          // if disabled, the value wouldn't be saved;
          controls.recipientResponse.setValue(null);

          if (value === config.values.select.notInList.value) {
            this.manageFields.enable([
              controls.organizationNotInList
            ]);
          } else {
            // determine if the department fields should be shown;
            this.recipientSelectDepartmentComponent.changeRecipient(controls.organization, this.values.organizations$.value);
          }
        }
      });
  }
}
