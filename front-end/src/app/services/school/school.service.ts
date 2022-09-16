import { catchError, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

import { ApiResponseSchoolProfile } from '../../interfaces/api-response-school-profile.interface';
import { CheckApiResponse } from '../../classes/check-api-response';
import { DataService } from '../../services/data/data.service';
import { environment } from '../../../environments/environment';
import { SecurityService } from '../../services/security/security.service';


@Injectable() export class SchoolService {
  constructor (
    private checkApiResponse: CheckApiResponse,
    private dataService: DataService,
    private http: HttpClient,
    private router: Router,
    private securityService: SecurityService
  ) {}

  getData (id): Observable<any> {
    const url = environment.local ? environment.schoolServiceURL : `${ environment.schoolServiceURL }/${ id }`;

    return this.http.get<any>(url)
      .pipe(
        tap(json => this.saveResponse(json)),
        catchError(error => this.securityService.catchResponse(error))
      );
  }

  saveResponse (json: ApiResponseSchoolProfile): void {
    if (this.checkApiResponse.isValid(json)) {
      this.dataService.save({
        schoolProfile: json
      });
    } else {
      throw new Error('Error found in valid response JSON');
    }
  }
}
