import { TestBed } from '@angular/core/testing';

import { CSRFInterceptorService } from './csrfinterceptor.service';

describe('CSRFInterceptorService', () => {
  let service: CSRFInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CSRFInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
