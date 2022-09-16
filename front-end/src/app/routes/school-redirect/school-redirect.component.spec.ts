import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolRedirectComponent } from './school-redirect.component';

describe('SchoolRedirectComponent', () => {
  let component: SchoolRedirectComponent;
  let fixture: ComponentFixture<SchoolRedirectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchoolRedirectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchoolRedirectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
