import { TestBed, inject } from '@angular/core/testing';

import { BlockingIndicatorService } from './blocking-indicator.service';

describe('BlockingIndicatorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BlockingIndicatorService]
    });
  });

  it('should be created', inject([BlockingIndicatorService], (service: BlockingIndicatorService) => {
    expect(service).toBeTruthy();
  }));
});
