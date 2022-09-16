import { BehaviorSubject,  Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { sortBy as _sortBy } from 'lodash';

import { ApiResponseRecipient } from '../../interfaces/api-response-recipient.interface';
import { environment } from '../../../environments/environment';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';


@Injectable() export class OrganizationsService implements OnDestroy {
  data$ = new BehaviorSubject(<SelectOption[]>[]);
  unsubscribe$ = new Subject();

  constructor (
    private http: HttpClient,
    private securityService: SecurityService
  ) {
    this.getData();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  getData (): void {
    this.http.get(environment.organizationsServiceURL)
      .pipe(
        takeUntil(this.unsubscribe$),
        catchError(error => this.securityService.catchResponse(error))
      )
      .subscribe((data: ApiResponseRecipient[]) => {
        // transform the data into a structure our component is expecting;
        const newValue = data.map((option: ApiResponseRecipient) => {
          return {
            ficeCode: option.ficeCode,
            name: option.schlName,
            orgType: option.orgType,
            sourceType: option.sourceType,
            value: option.schlName.toUpperCase()
          } as SelectOption;
        });

        const sortedValues = _sortBy(newValue, 'name');

        this.data$.next(sortedValues);
      });
  }
}
