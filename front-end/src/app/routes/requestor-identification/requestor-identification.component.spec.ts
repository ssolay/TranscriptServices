import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestorIdentificationComponent } from './requestor-identification.component';

describe('RequestorIdentificationComponent', () => {
  let component: RequestorIdentificationComponent;
  let fixture: ComponentFixture<RequestorIdentificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestorIdentificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestorIdentificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
