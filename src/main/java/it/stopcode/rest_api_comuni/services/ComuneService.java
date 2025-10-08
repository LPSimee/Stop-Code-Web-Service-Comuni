package it.stopcode.rest_api_comuni.services;

import it.stopcode.rest_api_comuni.exeptions.ComuneNotFoundException;
import it.stopcode.rest_api_comuni.exeptions.ExistingComuneException;
import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.repositories.ComuneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) { this.comuneRepository = comuneRepository; }

    @Transactional
    public List<Comune> findAllComuni(){
        return comuneRepository.findAll();
    };

    @Transactional
    public Comune findComuneByCodiceCatastale(String code){
        return comuneRepository.findByCodiceCatastale(code);
    }

    @Transactional
    public Comune createComune(Comune comune){

        String codiceCatastale = comune.getCodiceCatastale();

        if (comuneRepository.existsByCodiceCatastale(codiceCatastale)) {
            throw new ExistingComuneException();
        }

        return comuneRepository.save(comune);
    }

    @Transactional
    public Comune updateComuneByCodiceCatastale(Comune comuneDaInserire, String codiceCatastale){
        if(!comuneRepository.existsByCodiceCatastale(codiceCatastale)){
            throw new ComuneNotFoundException(codiceCatastale);
        }

        Comune comuneAggiornato = new Comune();

        comuneAggiornato.setNome(comuneDaInserire.getNome());
        comuneAggiornato.setCodiceCatastale(comuneDaInserire.getCodiceCatastale());
        comuneAggiornato.setProvincia(comuneDaInserire.getProvincia());
        comuneAggiornato.setCap(comuneDaInserire.getCap());
        comuneAggiornato.setPrefisso(comuneDaInserire.getPrefisso());
        comuneAggiornato.setMail(comuneDaInserire.getMail());
        comuneAggiornato.setPec(comuneDaInserire.getPec());
        comuneAggiornato.setTelefono(comuneDaInserire.getTelefono());
        comuneAggiornato.setFax(comuneDaInserire.getFax());
        comuneAggiornato.setCoordinate(comuneDaInserire.getCoordinate());

        return comuneRepository.save(comuneAggiornato);
    }

    @Transactional
    public boolean deleteComuneByCodiceCatastale(String code){
        long deletedCount = comuneRepository.deleteByCodiceCatastale(code);

        // Restituisce true se almeno una riga è stata eliminata.
        return deletedCount > 0;
    }
}
