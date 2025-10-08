package it.stopcode.rest_api_comuni.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingComuneException extends RuntimeException {
    public ExistingComuneException() {
        super("Codice Catastale Esistente");
    }
}
