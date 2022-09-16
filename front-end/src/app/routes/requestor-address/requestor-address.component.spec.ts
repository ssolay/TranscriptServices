import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestorAddressComponent } from './requestor-address.component';

describe('RequestorAddressComponent', () => {
  let component: RequestorAddressComponent;
  let fixture: ComponentFixture<RequestorAddressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestorAddressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestorAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
