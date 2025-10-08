package it.stopcode.rest_api_comuni.controllers;

import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.services.ComuneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comuni")
public class ComuneController {
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService){ this.comuneService = comuneService; }

    @GetMapping("/get")
    List<Comune> getAllComuni(){
        return comuneService.findAllComuni();
    };

    @GetMapping("/get/{codiceCatastale}")
    Comune getComuneByCatCode(@PathVariable String codiceCatastale){
        return comuneService.findComuneByCodiceCatastale(codiceCatastale);
    }

    @PostMapping("/create")
    ResponseEntity<Map<String, String>> insertNewComune(@RequestBody Comune comuneDaCreare){
        Comune created = comuneService.createComune(comuneDaCreare);

        Map<String, String> response = new HashMap<>();

        if(created != null) {
            response.put("code", "201 CREATED");
            response.put("message", "Comune Aggiunto");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            response.put("code", "400 BAD REQUEST");
            response.put("message", "Errore sull'inserimento del comune");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/update/{codiceCatastale}")
    ResponseEntity<Map<String, String>> updateComuneByCatCode(@RequestBody Comune nuovoComune, @PathVariable String codiceCatastale){
        Comune updated = comuneService.updateComuneByCodiceCatastale(nuovoComune, codiceCatastale);

        Map<String, String> response = new HashMap<>();

        if (updated != null) {
            response.put("code", "202 ACCEPTED");
            response.put("message", "Dati Comune Aggiornati");

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            response.put("code", "404 NOT FOUND");
            response.put("message", "Comune non trovato con codice catastale: " + codiceCatastale);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete/{codiceCatastale}")
    ResponseEntity<Map<String, String>> deleteComuneByCatCode(@PathVariable String codiceCatastale){
        boolean deleted = comuneService.deleteComuneByCodiceCatastale(codiceCatastale);

        Map<String, String> response = new HashMap<>();

        if (deleted) {
            response.put("code", "202 ACCEPTED");
            response.put("message", "Comune Eliminato");

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            response.put("code", "404 NOT FOUND");
            response.put("message", "Comune non trovato con codice catastale: " + codiceCatastale);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
} // ComuneController
