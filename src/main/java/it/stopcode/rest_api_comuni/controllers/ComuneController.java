package it.stopcode.rest_api_comuni.controllers;

import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.services.ComuneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return comuneService.findComuneByCatastralCode(codiceCatastale);
    }

    @DeleteMapping("/delete/{codiceCatastale}")
    ResponseEntity<Void> deleteComuneByCatCode(@PathVariable String codiceCatastale){

        return null;
    }
}
