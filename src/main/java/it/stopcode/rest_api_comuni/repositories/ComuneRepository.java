package it.stopcode.rest_api_comuni.repositories;

import it.stopcode.rest_api_comuni.models.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneRepository extends JpaRepository<Comune, String> {
    Comune findByName(String name);
}
