import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'nsc-blocking-indicator',
  templateUrl: './blocking-indicator.component.html',
  styleUrls: ['./blocking-indicator.component.scss']
})
export class BlockingIndicatorComponent implements OnInit {
  logoImage = '../../assets/tree.svg';
  constructor() {}

  ngOnInit() {
  }

}
