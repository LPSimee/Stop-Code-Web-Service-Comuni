package it.stopcode.rest_api_comuni.repositories;

import it.stopcode.rest_api_comuni.models.Comune;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ComuneRepository extends JpaRepository<Comune, Long> {

    // to return a specific Comune by its cadastral Code
    @Query("SELECT c FROM Comune c WHERE c.codiceCatastale = ?1")
    Optional<Comune> findByCodiceCatastale (String codiceCatastale);

    boolean existsByCodiceCatastale(String codiceCatastale);

    // to delete a specified Comune by the cadastral code
    @Transactional
    void deleteByCodiceCatastale(String codiceCatastale);
}
