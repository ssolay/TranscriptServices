import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFieldFilesComponent } from './form-field-files.component';

describe('FormFieldFilesComponent', () => {
  let component: FormFieldFilesComponent;
  let fixture: ComponentFixture<FormFieldFilesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFieldFilesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFieldFilesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
