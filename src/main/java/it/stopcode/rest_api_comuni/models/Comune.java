package it.stopcode.rest_api_comuni.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comuni")
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coordinata")
    private Coordinata coordinate;
}
