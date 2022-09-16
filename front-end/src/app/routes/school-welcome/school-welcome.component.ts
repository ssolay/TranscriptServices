import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { config } from '../../config/config';
import { CountriesService } from '../../services/countries/countries.service';
import { DataService } from '../../services/data/data.service';
import { OrganizationsService } from '../../services/organizations/organizations.service';
import { RecipientTypesService } from '../../services/recipient-types/recipient-types.service';
import { StatesService } from '../../services/states/states.service';


@Component({
  selector: 'nsc-school-welcome',
  templateUrl: './school-welcome.component.html',
  styleUrls: ['./school-welcome.component.scss']
})
export class SchoolWelcomeComponent implements OnInit {
  window: any = window; // so we can unescape the content in the HTML template;

  content = {
    welcomeMessage: this.dataService.getNote('34')
  };

  // most of these services aren't in use on this route;
  // but they are being loaded anyway to cache the data so the user doesn't have to wait later;
  // the user will be on this page reading, that gives the Ajax calls time to resolve;
  constructor (
    private countriesService: CountriesService,
    private dataService: DataService,
    private organizationsService: OrganizationsService,
    private recipientTypesService: RecipientTypesService,
    private router: Router,
    private statesService: StatesService
  ) {}

  ngOnInit () {
    // reset all but school profile data;
    // user may have gotten to this route by hitting the back button;
    // if so, we need to clear out any user entered data;
    this.dataService.resetUserData();
  }

  continue (): void {
    this.router.navigate([config.routes.requestorIdentification]);
  }
}
