package it.stopcode.rest_api_comuni.services;

import it.stopcode.rest_api_comuni.repositories.ComuneRepository;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) { this.comuneRepository = comuneRepository; }
}
