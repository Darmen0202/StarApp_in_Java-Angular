import { TestBed } from '@angular/core/testing';

import { AstronomerService } from './astronomer.service';

describe('AstronomerService', () => {
  let service: AstronomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AstronomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
