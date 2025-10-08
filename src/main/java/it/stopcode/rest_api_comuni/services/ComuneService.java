package it.stopcode.rest_api_comuni.services;

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

    @Transactional
    public List<Comune> findAllComuni(){
        return comuneRepository.findAll();
    };

    @Transactional
    public Comune findComuneByCodiceCatastale(String code){
        return comuneRepository.findByCodiceCatastale(code).orElse(null);
    }

    @Transactional
    public Comune createComune(Comune comune){
        String codiceCatastale = comune.getCodiceCatastale();

        if (comuneRepository.existsByCodiceCatastale(codiceCatastale)) {
            return null;
        }

        return comuneRepository.save(comune);
    }

    @Transactional
    public Comune updateComuneByCodiceCatastale(Comune comuneDaInserire, String codiceCatastale){

        Optional<Comune> comuneOpt = comuneRepository.findByCodiceCatastale(codiceCatastale);

        if (comuneOpt.isEmpty()){
            return null; // NOT FOUND (404)
        }

        Comune comuneAggiornato = comuneOpt.get();
        String nuovoCodiceCatastale = comuneDaInserire.getCodiceCatastale();

        // Controllo CONFLITTO (409) - Richiede il metodo existsByCodiceCatastaleAndIdNot
        // **SENZA quel metodo, non possiamo fare il controllo 409 in modo sicuro!**

        // Se non fai il controllo 409, prosegui:

        // BUG FIX 2: Aggiorna i campi del comune ESISTENTE, non creare un nuovo oggetto!
        comuneAggiornato.setNome(comuneDaInserire.getNome());
        comuneAggiornato.setCodiceCatastale(nuovoCodiceCatastale);
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
        if (!comuneRepository.existsByCodiceCatastale(code)) {
            return false; // Comune non trovato (404)
        }

        comuneRepository.deleteByCodiceCatastale(code);
        return true;
    }

//    @Transactional
//    public boolean deleteComuneById(Long id) {
//
//        // 1. Controllo esistenza (per il 404 Not Found)
//        if (!comuneRepository.existsById(id)) {
//            return false; // Comune non trovato (404)
//        }
//
//        // 2. Eliminazione
//        // Grazie a CascadeType.ALL sul modello Comune, questa operazione
//        // eliminerà anche le Coordinate associate.
//        comuneRepository.deleteById(id);
//
//        // L'eliminazione è riuscita
//        return true;
//    }
}
