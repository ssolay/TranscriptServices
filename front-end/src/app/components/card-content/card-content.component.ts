import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'nsc-card-content',
  templateUrl: './card-content.component.html',
  styleUrls: ['./card-content.component.scss']
})
export class CardContentComponent implements OnInit {
  @Input('class') class: string;

  constructor () {}

  ngOnInit () {}
}
