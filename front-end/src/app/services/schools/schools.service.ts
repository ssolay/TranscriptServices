import { BehaviorSubject,  Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { sortBy as _sortBy } from 'lodash';
import { takeUntil } from 'rxjs/operators';

import { ApiResponseSchool } from '../../interfaces/api-response-school.interface';
import { AutocompleteOption } from '../../interfaces/autocomplete-option.interface';
import { environment } from '../../../environments/environment';


@Injectable() export class SchoolsService implements OnDestroy {
  data$ = new BehaviorSubject(<AutocompleteOption[]>[]);
  unsubscribe$ = new Subject();

  constructor (private http: HttpClient) {
    this.getData();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  getData () {
    this.http.get(environment.schoolsServiceURL)
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((data: ApiResponseSchool[]) => {
        const sortedValues = _sortBy(data, 'name');

        this.data$.next(sortedValues);
      });
  }
}
