import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { ApiResponseRecipient } from '../../interfaces/api-response-recipient.interface';
import { environment } from '../../../environments/environment';


@Injectable() export class SchoolsByStateService {
  constructor (private http: HttpClient) {}

  getData (state) {
    const url = environment.local ? environment.schoolsByStateServiceURL : `${ environment.schoolsByStateServiceURL }/${ state }`;

    return this.http.get<ApiResponseRecipient[]>(url);
  }
}
