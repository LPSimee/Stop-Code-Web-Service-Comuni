package it.stopcode.rest_api_comuni.controllers;

import it.stopcode.rest_api_comuni.services.ComuneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comuni")
public class ComuneController {
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService){ this.comuneService = comuneService; }

}
