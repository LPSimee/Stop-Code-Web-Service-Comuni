package it.stopcode.rest_api_comuni.services;

import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.repositories.ComuneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) { this.comuneRepository = comuneRepository; }

    public List<Comune> findAllComuni(){
        return comuneRepository.findAll();
    };

    public Comune findComuneByCadastralCode(String code){
        return comuneRepository.findByCodiceCatastale(code);
    }

    @Transactional
    public Comune createComune(Comune comune){
        return comuneRepository.save(comune);
    }

    @Transactional
    public Comune updateComune(Comune comuneDaInserire){
        return null;
    }

    @Transactional
    public void deleteComuneByCadastralCode(String code){
        comuneRepository.deleteByCodiceCatastale(code);
    }
}
