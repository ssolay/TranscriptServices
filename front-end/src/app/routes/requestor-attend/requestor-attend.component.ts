import * as moment from 'moment';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { ManageFields } from '../../classes/manage-fields';
import { PostService } from '../../services/post/post.service';
import { SecurityService } from '../../services/security/security.service';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateDateEnrolled } from '../../validators/date-enrolled.validator';
import { ValidateRequireOne } from '../../validators/require-one.validator';


@Component({
  selector: 'nsc-requestor-attend',
  templateUrl: './requestor-attend.component.html',
  styleUrls: ['./requestor-attend.component.scss']
})
export class RequestorAttendComponent implements OnDestroy, OnInit {
  data = this.dataService.get();
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  content = {
    programLabels: this.data.schoolProfile.attendSchoolLabels
  };

  masks = {
    year: [/\d/, /\d/, /\d/, /\d/]
  };

  require = {
    programs: this.data.schoolProfile.askSchools === 'R',
    programsYear: this.data.schoolProfile.askEnrollYears === 'R'
  };

  show = {
    degreeQuestions: this.dataService.showDegreeQuestions(),
    programQuestions: this.dataService.showProgramQuestions(),
    programYearQuestions: this.data.schoolProfile.askEnrollYears !== 'N'
  };

  values = {
    programsYearValidators: [
      Validators.minLength(4),
      Validators.min(1940),
      Validators.max(moment().year() + 1)
    ],
    programsYearValidatorsRequired: [
      Validators.minLength(4),
      Validators.min(1940),
      Validators.max(moment().year() + 1),
      Validators.required
    ]
  };

  constructor (
    private blockingIndicatorService: BlockingIndicatorService,
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private postService: PostService,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initForm();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initForm (): void {
    const attend = this.data.form.requestor.attend;
    const programsGroup = this.initPrograms();
    const programControls = programsGroup.map(group => group.controls.program);
    const yearValidators = [
      Validators.minLength(4),
      Validators.min(1940),
      Validators.max(moment().year())
    ];
    const formValidator = this.require.programs
      ? [ ValidateRequireOne(programControls) ]
      : null;

    this.formGroup = this.formBuilder.group({
      programs: this.formBuilder.array(programsGroup),
      degree1: new FormControl(attend.degree1),
      degree2: new FormControl(attend.degree2),
      degree3: new FormControl(attend.degree3),
      degree4: new FormControl(attend.degree4),
      year1: new FormControl(attend.year1, yearValidators),
      year2: new FormControl(attend.year2, yearValidators),
      year3: new FormControl(attend.year3, yearValidators),
      year4: new FormControl(attend.year4, yearValidators)
    }, {
      validator: formValidator
    });

    const controls = this.formGroup.controls;

    if (this.show.degreeQuestions === false) {
      this.manageFields.disable([
        controls.degree1,
        controls.degree2,
        controls.degree3,
        controls.degree4,
        controls.year1,
        controls.year2,
        controls.year3,
        controls.year4
      ]);
    }

    // disable any created program controls;
    // because they may be defined even if they aren't suppose to be shown to the user;
    if (this.show.programQuestions === false) {
      controls.programs.disable();
    }

    // any change to the form means the user is actively using the app, so extend the system timeout;
    this.formGroup.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(value => {
        this.timeoutService.startWarningCountdown();
      });
  }

  initPrograms (): FormGroup[] {
    const array = [];

    // create a set of form controls for each label defined in the school profile;
    this.content.programLabels.map(program => {
      const yearFromValidators = this.require.programsYear
        ? this.values.programsYearValidatorsRequired
        : this.values.programsYearValidators;

      array.push(
        this.formBuilder.group({
          program: new FormControl(false),
          yearFrom: new FormControl(config.values.nullDisabled, yearFromValidators),
          yearTo: new FormControl(config.values.nullDisabled, [
            Validators.minLength(4),
            Validators.min(1940)
          ])
        }, {
          validator: [ ValidateDateEnrolled('yearFrom', 'yearTo') ]
        })
      );
    });

    return array;
  }

  changeProgram (event: any, yearFrom: AbstractControl, yearTo: AbstractControl): void {
    if (this.show.programYearQuestions) {
      if (event.checked) {
        this.manageFields.enable([
          yearFrom,
          yearTo
        ]);
      } else {
        this.manageFields.disable([
          yearFrom,
          yearTo
        ]);
      }
    }
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    this.dataService.resetRequestorAttend();
    this.dataService.save(this.formGroup.value, 'form.requestor.attend');

    this.blockingIndicatorService.open();

    this.postService.student()
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(() => {
        window.setTimeout(() => {
          this.securityService.setDeactivateWarning(false);

          this.router.navigate([config.routes.recipientSelect], config.routes.extras);
        }, config.values.loading.delay);
      });
  }
}
