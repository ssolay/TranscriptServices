import { TestBed, inject } from '@angular/core/testing';

import { SchoolsByStateService } from './schools-by-state.service';

describe('SchoolsByStateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SchoolsByStateService]
    });
  });

  it('should be created', inject([SchoolsByStateService], (service: SchoolsByStateService) => {
    expect(service).toBeTruthy();
  }));
});
