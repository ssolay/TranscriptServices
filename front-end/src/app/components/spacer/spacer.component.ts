import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'nsc-spacer',
  templateUrl: './spacer.component.html',
  styleUrls: ['./spacer.component.scss']
})
export class SpacerComponent implements OnInit {
  @Input('horizontal') horizontal: boolean;
  @Input('size') size: string;

  constructor () {}

  ngOnInit () {}
}
