import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockingIndicatorComponent } from './blocking-indicator.component';

describe('BlockingIndicatorComponent', () => {
  let component: BlockingIndicatorComponent;
  let fixture: ComponentFixture<BlockingIndicatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlockingIndicatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockingIndicatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
