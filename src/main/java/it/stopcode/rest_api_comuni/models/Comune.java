package it.stopcode.rest_api_comuni.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String codiceCatastale;
    private String cap;
    private String prefisso;
    private String mail;
    private String pec;
    private String telefono;
    private String fax;
    private String[] coordinate; // mettere il collegamento con l'altra entità
}
