import * as moment from 'moment';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'nsc-app-footer',
  templateUrl: './app-footer.component.html',
  styleUrls: ['./app-footer.component.scss']
})
export class AppFooterComponent implements OnInit {
  copyrightYear = moment().year();

  constructor () {}

  ngOnInit () {}
}
