import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFieldToggleComponent } from './form-field-toggle.component';

describe('FormFieldToggleComponent', () => {
  let component: FormFieldToggleComponent;
  let fixture: ComponentFixture<FormFieldToggleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFieldToggleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFieldToggleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
