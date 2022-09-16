import { AfterViewInit, Component, OnInit } from '@angular/core';
import { debounceTime } from 'rxjs/operators';
import { fromEvent } from 'rxjs';


@Component({
  selector: 'nsc-scroll-to-top',
  templateUrl: './scroll-to-top.component.html',
  styleUrls: ['./scroll-to-top.component.scss']
})
export class ScrollToTopComponent implements AfterViewInit, OnInit {
  show = {
    button: false
  };

  values = {
    scrollPositionTrigger: window.innerHeight / 2
  };

  constructor () {}

  ngAfterViewInit () {
    // run after the view is initalized so the browser adjusts the inital scroll position;
    // if we run before, pageYOffset is 0;
    this.toggleButtonVisibility();
  }

  ngOnInit () {
    // check to see if the button should be visible;
    fromEvent(window, 'scroll')
      .pipe(
        debounceTime(150)
      )
      .subscribe(() => {
        this.toggleButtonVisibility();
      });
  }

  scrollToTop (): void {
    window.scrollTo(0, 0);
  }

  toggleButtonVisibility (): void {
    this.show.button = window.pageYOffset > this.values.scrollPositionTrigger;
  }
}
