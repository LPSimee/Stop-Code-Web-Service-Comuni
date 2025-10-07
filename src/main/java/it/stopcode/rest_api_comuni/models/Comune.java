package it.stopcode.rest_api_comuni.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comune {

    @Id
    private int id;
    private String nome;
    private String codiceCatastale;
    private String cap;
    private String prefisso;
    private String mail;
    private String pec;
    private String telefono;
    private String fax;
    private String[] coordinate;
}
