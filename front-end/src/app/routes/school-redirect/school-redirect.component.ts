import { ActivatedRoute } from '@angular/router';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { SchoolService } from '../../services/school/school.service';


@Component({
  selector: 'nsc-school-redirect',
  templateUrl: './school-redirect.component.html',
  styleUrls: ['./school-redirect.component.scss']
})
export class SchoolRedirectComponent implements OnDestroy, OnInit {
  unsubscribe$ = new Subject();

  constructor (
    private activatedRoute: ActivatedRoute,
    private dataService: DataService,
    private blockingIndicatorService: BlockingIndicatorService,
    private router: Router,
    private schoolService: SchoolService
  ) {}

  ngOnInit () {
    // enable progress bar, it will be disabled after route change;
    this.blockingIndicatorService.open();

    this.activatedRoute.params
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(params => {
        // get the full school profile based on the ficeCode in the URL;
        // then move to the next page;
        this.schoolService.getData(params.ficeCode)
          .pipe(
            takeUntil(this.unsubscribe$)
          )
          .subscribe(() => {
            // force a small delay;
            window.setTimeout(() => {
              this.router.navigate([config.routes.schoolWelcome], config.routes.extras);
            }, config.values.loading.delay);
          });
      });
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}
