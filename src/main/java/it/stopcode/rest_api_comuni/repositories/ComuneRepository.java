package it.stopcode.rest_api_comuni.repositories;

import it.stopcode.rest_api_comuni.models.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComuneRepository extends JpaRepository<Comune, Long> {

    Comune findByCodiceCatastale (String codiceCatastale);
}
