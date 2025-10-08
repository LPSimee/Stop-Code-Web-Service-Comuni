package it.stopcode.rest_api_comuni.controllers;

import it.stopcode.rest_api_comuni.models.Comune;
import it.stopcode.rest_api_comuni.services.ComuneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comuni")
public class ComuneController {
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService){ this.comuneService = comuneService; }

    @GetMapping
    List<Comune> getAllComuni(){
        return comuneService.findAllComuni();
    };
}
