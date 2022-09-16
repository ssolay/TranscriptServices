import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientSelectCollegeComponent } from './recipient-select-college.component';

describe('RecipientSelectCollegeComponent', () => {
  let component: RecipientSelectCollegeComponent;
  let fixture: ComponentFixture<RecipientSelectCollegeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipientSelectCollegeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientSelectCollegeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
