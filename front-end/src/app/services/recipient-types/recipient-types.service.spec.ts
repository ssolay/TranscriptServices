import { TestBed, inject } from '@angular/core/testing';

import { RecipientTypesService } from './recipient-types.service';

describe('RecipientTypesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RecipientTypesService]
    });
  });

  it('should be created', inject([RecipientTypesService], (service: RecipientTypesService) => {
    expect(service).toBeTruthy();
  }));
});
