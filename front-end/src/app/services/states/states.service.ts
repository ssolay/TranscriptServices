import { BehaviorSubject,  Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';

import { ApiResponseState } from '../../interfaces/api-response-state.interface';
import { environment } from '../../../environments/environment';
import { SecurityService } from '../../services/security/security.service';
import { SelectOptgroup} from '../../interfaces/select-optgroup.interface';
import { SelectOption } from '../../interfaces/select-option.interface';
import { States } from '../../interfaces/states.interface';


@Injectable() export class StatesService implements OnDestroy {
  data$ = new BehaviorSubject(<States>{});
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
    this.http.get(environment.statesServiceURL)
      .pipe(
        takeUntil(this.unsubscribe$),
        catchError(error => this.securityService.catchResponse(error))
      )
      .subscribe((data: ApiResponseState[]) => {
        const us = <SelectOptgroup[]>[
          {
            label: 'States',
            options: []
          },
          {
            label: 'Territories',
            options: []
          },
          {
            label: 'Army Post Offices',
            options: []
          }
        ];
        const canada = <SelectOptgroup[]>[
          {
            label: 'Provinces',
            options: []
          },
          {
            label: 'Territories',
            options: []
          }
        ];
        let international = <string>'';

        // transform the data into a structure our component is expecting (a SelectOption);
        const newValues = data.map((option: ApiResponseState) => {
          return {
            name: option.description,
            value: option.code.toUpperCase(),
            category: option.category
          };
        });

        // now organize the values by country;
        newValues.forEach((state: SelectOption) => {
          switch (state.category) {
            case 'U':
              us[0].options.push(state);
              break;

            case 'T':
              us[1].options.push(state);
              break;

            case 'A':
              us[2].options.push(state);
              break;

            case 'C':
              // canadian regions are not broken up, in the back-end;
              // but we want to break the up in the front-end;
              if (['NT', 'NU', 'YT'].indexOf(state.value) === -1) {
                canada[0].options.push(state);
              } else {
                canada[1].options.push(state);
              }
              break;

            case 'I':
              international = state.value;
              break;
          }
        });

        // return all three arrays for each component to hide/show as needed;
        this.data$.next({ us, canada, international });
      });
  }
}
