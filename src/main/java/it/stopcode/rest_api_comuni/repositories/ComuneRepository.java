package it.stopcode.rest_api_comuni.repositories;

import it.stopcode.rest_api_comuni.models.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComuneRepository extends JpaRepository<Comune, Long> {
    List<Comune> findAllComuni();
}
