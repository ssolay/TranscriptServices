import { BehaviorSubject,  Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';

import { ApiResponseCountry } from '../../interfaces/api-response-country.interface';
import { environment } from '../../../environments/environment';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';


@Injectable() export class CountriesService implements OnDestroy {
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
    this.http.get(environment.countriesServiceURL)
      .pipe(
        takeUntil(this.unsubscribe$),
        catchError(error => this.securityService.catchResponse(error))
      )
      .subscribe((data: ApiResponseCountry[]) => {
        // transform the data into a structure our component is expecting;
        const newValue = data.map((option: ApiResponseCountry) => {
          return {
            name: option.description,
            value: option.code.toUpperCase()
          } as SelectOption;
        });

        this.data$.next(newValue);
      });
  }
}
