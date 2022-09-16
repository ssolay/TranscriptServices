import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFieldConfirmComponent } from './form-field-confirm.component';

describe('FormFieldConfirmComponent', () => {
  let component: FormFieldConfirmComponent;
  let fixture: ComponentFixture<FormFieldConfirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFieldConfirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFieldConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
