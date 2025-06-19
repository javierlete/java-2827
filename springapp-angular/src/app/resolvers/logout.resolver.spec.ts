import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';

import { logoutResolver } from './logout.resolver';

describe('logoutResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) => 
      TestBed.runInInjectionContext(() => logoutResolver(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
