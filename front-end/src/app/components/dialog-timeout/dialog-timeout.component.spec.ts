import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogTimeoutComponent } from './dialog-timeout.component';

describe('DialogTimeoutComponent', () => {
  let component: DialogTimeoutComponent;
  let fixture: ComponentFixture<DialogTimeoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogTimeoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogTimeoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
