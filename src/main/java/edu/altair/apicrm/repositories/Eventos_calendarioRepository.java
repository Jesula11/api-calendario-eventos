package edu.altair.apicrm.repositories;

import edu.altair.apicrm.entities.Eventos_calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Eventos_calendarioRepository extends JpaRepository<Eventos_calendario, Long> {


}
