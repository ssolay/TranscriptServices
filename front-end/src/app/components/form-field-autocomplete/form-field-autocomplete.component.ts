import { Component, Input, OnInit, ViewChild, ElementRef, QueryList } from '@angular/core';
import { distinctUntilChanged } from 'rxjs/operators';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { filter as _filter } from 'lodash';
import { fromEvent } from 'rxjs';

import { AutocompleteOption } from '../../interfaces/autocomplete-option.interface';
import { config } from '../../config/config';


@Component({
  selector: 'nsc-form-field-autocomplete',
  templateUrl: './form-field-autocomplete.component.html',
  styleUrls: ['./form-field-autocomplete.component.scss'],
})
export class FormFieldAutocompleteComponent implements OnInit {
  @Input() controlName: string;
  @Input() group: FormGroup;
  @Input() hint: string;
  @Input() notInList: boolean;
  @Input() options: AutocompleteOption[];
  @Input() placeholder: string;
  @Input() loading = false;

  @ViewChild('itemFilterInput') itemFilterInput: ElementRef;
  @ViewChild('optionList', {read: ElementRef}) optionList: ElementRef;

  focusTimeout: number;
  focusTimeoutDelay = 250;
  highlightedItem = -1;
  inputTimeout: number;
  inputTimeoutDelay: 300;
  minCharactersToTrigger = 2;

  show = {
    autocomplete: false
  };

  values = {
    autocomplete: [] // options to display to the user;
  };

  constructor () {}

  ngOnInit () {
    this.configureAutocomplete();
  }

  configureAutocomplete (): void {
    fromEvent(this.itemFilterInput.nativeElement, 'keyup')
      .pipe(
        distinctUntilChanged()
      )
      .subscribe((e: KeyboardEvent) => {
        this.keyUpHandler(e);
      });
  }

  showOptions (): void {
    // I removed 'debounce' from the Event Observable and I am replicating it's behavior
    // with this inputTimeout timer object
    window.clearTimeout(this.inputTimeout);
    const value = this.itemFilterInput.nativeElement.value;
    this.highlightedItem = -1;
    if (value && value.length >= this.minCharactersToTrigger) {
      // create a list where the entered value matchs something in the name;
      this.values.autocomplete = _filter(this.options, (option: AutocompleteOption) => {
        return option.name.toLowerCase().indexOf(value.toLowerCase()) === 0;
      });

      // push the 'not in list' option;
      if (this.notInList) {
        this.values.autocomplete.push(config.values.autocomplete.notInList);
      }

      // if there are no entries, add a non-selectable entry to display a message to the user;
      if (!this.notInList && this.values.autocomplete.length === 0) {
        this.values.autocomplete = [config.values.autocomplete.noMatch];
      }

      this.show.autocomplete = true;
    // if the form is less than X characters, show nothing - not even an error message;
    } else {
      this.values.autocomplete = [];
    }
  }

  hideOptions (): void {
    this.show.autocomplete = false;
    this.highlightedItem = -1;
  }

  // whenever an option of the form field is focused, clear any existing timeout, and show the autocomplete options;
  // so if the form field already has content in it on focus, options are shown;
  onFocus (): void {
    window.clearTimeout(this.focusTimeout);
    this.showOptions();
  }

  // on leaving the input or option, start a timeout to hide the options;
  // we dont want to immediately hide the options because the user may be transitioning from the input to an option;
  // give the app time to manage that change in focus to options aren't hidden immediately on blur;
  onBlur (): void {
    this.focusTimeout = window.setTimeout(() => this.hideOptions(), this.focusTimeoutDelay);
  }

  // on select of an option, set the input value and hide the options (since we no longer need them);
  // use the blur event to hide so there is a slight delay (so it is't jarring to the user);
  selectOption (item): void {
    if (item) {
      this.group.controls[this.controlName].setValue(item.name);
      this.onBlur();
    }
  }

  // hovering on an option needs to overwrite whatever item was selected with the arrow keys
  optionHoverHandler (e, i): void {
    this.highlightedItem = i;
  }


  // sets the highlighted state for options
  optionClass (i): string {
    if (i === this.highlightedItem) {
      return 'mat-selected';
    }
    return '';
  }

  // These two methods control scrolling. To make the scrolling work as expected, it gets a bit more
  // complicated than expected.
  scrollUpToOption (i): void {
    const itemHeight = this.optionList.nativeElement.firstElementChild.offsetHeight;
    const oldScroll = this.optionList.nativeElement.scrollTop;
    const newScroll = i * itemHeight;

    this.optionList.nativeElement.scrollTop = oldScroll > newScroll ? newScroll : oldScroll;
  }

  scrollDownToOption (i): void {
    const maxHeight = this.optionList.nativeElement.offsetHeight;
    const itemHeight = this.optionList.nativeElement.firstElementChild.offsetHeight;
    const oldScroll = this.optionList.nativeElement.scrollTop;
    const newScroll = (i - Math.floor(maxHeight / itemHeight) + 1) * itemHeight;

    this.optionList.nativeElement.scrollTop = oldScroll < newScroll ? newScroll : oldScroll;
  }

  // catch keyup events from the input field
  keyUpHandler (e): void {
    if (this.show.autocomplete && this.values.autocomplete.length >= 1) {
      if (e.code === 'ArrowDown' || e.key === 'Down') {
        if (this.highlightedItem < this.values.autocomplete.length - 1) {
          this.highlightedItem++;
          if (this.highlightedItem > 4) {
            window.setTimeout(this.scrollDownToOption(this.highlightedItem), 200);
          }
        }
      } else if (e.code === 'ArrowUp' || e.key === 'Up') {
        if (this.highlightedItem > 0) {
          this.highlightedItem--;
          if (this.highlightedItem < this.values.autocomplete.length - 5) {
            window.setTimeout(this.scrollUpToOption(this.highlightedItem), 200);
          }
        }
      } else if (e.code === 'Enter' || e.key === 'Enter') {
        this.selectOption(this.values.autocomplete[this.highlightedItem]);
      } else {
        this.inputTimeout = window.setTimeout(() => this.showOptions(), this.inputTimeoutDelay);
      }
    } else {
      this.inputTimeout = window.setTimeout(() => this.showOptions(), this.inputTimeoutDelay);
    }
  }
}
