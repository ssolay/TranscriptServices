import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFieldSelectOptgroupComponent } from './form-field-select-optgroup.component';

describe('FormFieldSelectOptgroupComponent', () => {
  let component: FormFieldSelectOptgroupComponent;
  let fixture: ComponentFixture<FormFieldSelectOptgroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFieldSelectOptgroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFieldSelectOptgroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
