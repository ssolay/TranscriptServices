import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolWelcomeComponent } from './school-welcome.component';

describe('SchoolWelcomeComponent', () => {
  let component: SchoolWelcomeComponent;
  let fixture: ComponentFixture<SchoolWelcomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchoolWelcomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchoolWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
