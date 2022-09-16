import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderConsentComponent } from './order-consent.component';

describe('OrderConsentComponent', () => {
  let component: OrderConsentComponent;
  let fixture: ComponentFixture<OrderConsentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderConsentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderConsentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
