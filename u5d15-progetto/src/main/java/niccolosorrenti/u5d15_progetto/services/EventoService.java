package niccolosorrenti.u5d15_progetto.services;

import niccolosorrenti.u5d15_progetto.entities.Evento;
import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento creaEvento(Evento evento, Utente organizzatore) {
        evento.setOrganizzatore(organizzatore);
        evento.setPostiDisponibili(evento.getPostiTotali());
        return eventoRepository.save(evento);
    }

    public List<Evento> getTuttiEventi() {
        return eventoRepository.findAll();
    }

    public Evento findEventoPerId(UUID id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento non trovato"));
    }

    public void eliminaEvento(UUID id) {
        eventoRepository.deleteById(id);
    }

    public List<Evento> eventiPerOrganizzatore(Utente organizzatore) {
        return eventoRepository.findByOrganizzatore(organizzatore);
    }
}
