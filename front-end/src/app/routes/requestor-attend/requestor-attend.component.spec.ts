import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestorAttendComponent } from './requestor-attend.component';

describe('RequestorAttendComponent', () => {
  let component: RequestorAttendComponent;
  let fixture: ComponentFixture<RequestorAttendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestorAttendComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestorAttendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
