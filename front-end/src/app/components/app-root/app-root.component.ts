import { Component, OnInit } from '@angular/core';
import { catchError, distinctUntilChanged, debounceTime, filter, map, takeUntil } from 'rxjs/operators';
import { Location } from '@angular/common';
import { MatDialog } from '@angular/material';
import { NavigationEnd, Router } from '@angular/router';

import { config } from '../../config/config';
import { DialogTimeoutComponent } from '../../components/dialog-timeout/dialog-timeout.component';
import { TimeoutService } from '../../services/timeout/timeout.service';


@Component({
  selector: 'nsc-app-root',
  templateUrl: './app-root.component.html',
  styleUrls: ['./app-root.component.scss']
})
export class AppRootComponent implements OnInit {
  dialogWarning;
  route: string;

  constructor (
    private dialog: MatDialog,
    private location: Location,
    private router: Router,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    // on route change change settings (when the navigation ends);
    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd)
      )
      .subscribe((event) => {
        // define the routes where the timer shouldn't start;
        const routesNoTimeout = [
          config.routes.schoolSelect,
          config.routes.messageComplete,
          config.routes.messageError,
          config.routes.messageTimeout
        ];

        // update the route so the header can display the proper data in the proper layout;
        this.route = this.location.path().replace('/', '');

        // set the timeout on route change, so we dont have to set it on every route init function;
        // if the user isn't on the first page of the app;
        if (routesNoTimeout.indexOf(this.route) === -1) {
          this.timeoutService.startWarningCountdown();
        }
      });

    this.timeoutService.showWarning.subscribe((showDialog: boolean) => {
      if (showDialog) {
        this.displayWarning();
      } else if (this.dialogWarning) {
        this.dialogWarning.close();
      }
    });
  }

  // on route change, scroll to top of page;
  onDeactivate () {
    window.scrollTo(0, 0);
  }

  displayWarning (): void {
    // close any existing warning dialog before showing a new one;
    if (this.dialogWarning) {
      this.dialogWarning.close();
    }

    // show the new warning dialog;
    this.dialogWarning = this.dialog.open(DialogTimeoutComponent, {
      disableClose: true,
      width: '480px'
    });
  }
}
