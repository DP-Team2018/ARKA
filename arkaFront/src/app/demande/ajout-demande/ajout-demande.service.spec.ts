import { TestBed, inject } from '@angular/core/testing';

import { AjoutDemandeService } from './ajout-demande.service';

describe('AjoutDemandeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AjoutDemandeService]
    });
  });

  it('should be created', inject([AjoutDemandeService], (service: AjoutDemandeService) => {
    expect(service).toBeTruthy();
  }));
});
