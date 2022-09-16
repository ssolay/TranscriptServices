import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientEmailComponent } from './recipient-email.component';

describe('RecipientEmailComponent', () => {
  let component: RecipientEmailComponent;
  let fixture: ComponentFixture<RecipientEmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientEmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
