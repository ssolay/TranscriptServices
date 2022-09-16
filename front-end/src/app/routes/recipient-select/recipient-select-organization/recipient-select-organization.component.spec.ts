import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientSelectOrganizationComponent } from './recipient-select-organization.component';

describe('RecipientSelectOrganizationComponent', () => {
  let component: RecipientSelectOrganizationComponent;
  let fixture: ComponentFixture<RecipientSelectOrganizationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientSelectOrganizationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientSelectOrganizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
