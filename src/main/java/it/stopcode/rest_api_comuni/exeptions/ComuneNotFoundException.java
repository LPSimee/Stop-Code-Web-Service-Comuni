package it.stopcode.rest_api_comuni.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ComuneNotFoundException extends RuntimeException {
    public ComuneNotFoundException(String codiceCatastale) {
        super("Comune non trovato con codice catastale: " + codiceCatastale);
    }
}
