import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientSelectDepartmentComponent } from './recipient-select-department.component';

describe('RecipientSelectDepartmentComponent', () => {
  let component: RecipientSelectDepartmentComponent;
  let fixture: ComponentFixture<RecipientSelectDepartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientSelectDepartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientSelectDepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
