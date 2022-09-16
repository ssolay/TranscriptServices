import { catchError, takeUntil } from 'rxjs/operators';
import { BehaviorSubject,  Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { sortBy as _sortBy } from 'lodash';

import { ApiResponseRecipientType } from '../../interfaces/api-response-recipient-type.interface';
import { environment } from '../../../environments/environment';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';


@Injectable() export class RecipientTypesService implements OnDestroy {
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
    this.http.get(environment.recipientTypesServiceURL)
      .pipe(
        takeUntil(this.unsubscribe$),
        catchError(error => this.securityService.catchResponse(error))
      )
      .subscribe((data: ApiResponseRecipientType[]) => {
        // transform the data into a structure our component is expecting;
        const newValue = data.map((option: ApiResponseRecipientType) => {
          return {
            name: option.description,
            value: option.code.toUpperCase()
          } as SelectOption;
        });

        const sortedValues = _sortBy(newValue, 'name');

        this.data$.next(sortedValues);
      });
  }
}
