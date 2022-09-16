import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientDeliveryMethodComponent } from './recipient-delivery-method.component';

describe('RecipientDeliveryMethodComponent', () => {
  let component: RecipientDeliveryMethodComponent;
  let fixture: ComponentFixture<RecipientDeliveryMethodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientDeliveryMethodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientDeliveryMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
