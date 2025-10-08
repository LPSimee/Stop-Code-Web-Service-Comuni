package it.stopcode.rest_api_comuni.services;

import it.stopcode.rest_api_comuni.exeptions.ExistingComuneException;
import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.repositories.ComuneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (comune.getId() != 0) {
            throw new IllegalArgumentException("Non è possibile specificare l'ID durante la creazione di un nuovo Comune.");
        }

        String codiceCatastale = comune.getCodiceCatastale();

        if (comuneRepository.existsByCodiceCatastale(codiceCatastale)) {
            throw new ExistingComuneException();
        }

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
