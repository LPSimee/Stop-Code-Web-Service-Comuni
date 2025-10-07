package it.stopcode.rest_api_comuni.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comune {
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
