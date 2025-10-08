package it.stopcode.rest_api_comuni.services;

import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.repositories.ComuneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) { this.comuneRepository = comuneRepository; }

    List<Comune> findAllComuni(){
        return comuneRepository.findAll();
    };

    Comune findComuneByCatastralCode(String code){
        return comuneRepository.findByCodiceCatastale(code);
    }
}
