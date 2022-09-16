import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientDeliveryMethodFeesComponent } from './recipient-delivery-method-fees.component';

describe('RecipientDeliveryMethodFeesComponent', () => {
  let component: RecipientDeliveryMethodFeesComponent;
  let fixture: ComponentFixture<RecipientDeliveryMethodFeesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientDeliveryMethodFeesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientDeliveryMethodFeesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
