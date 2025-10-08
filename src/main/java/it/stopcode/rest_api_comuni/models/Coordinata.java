package it.stopcode.rest_api_comuni.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coordinate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double lat;
    private double lng;

}
