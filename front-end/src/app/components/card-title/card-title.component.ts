import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'nsc-card-title',
  templateUrl: './card-title.component.html',
  styleUrls: ['./card-title.component.scss']
})
export class CardTitleComponent implements OnInit {
  @Input('error') error: string;
  @Input('note') note: string;
  @Input('shoppingCartCount') shoppingCartCount: number;

  constructor () {}

  ngOnInit () {}
}
