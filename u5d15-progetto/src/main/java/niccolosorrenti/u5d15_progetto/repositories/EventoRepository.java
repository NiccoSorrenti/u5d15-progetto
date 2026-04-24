package niccolosorrenti.u5d15_progetto.repositories;

import niccolosorrenti.u5d15_progetto.entities.Evento;
import niccolosorrenti.u5d15_progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

    List<Evento> findByOrganizzatore(Utente organizzatore);
}
