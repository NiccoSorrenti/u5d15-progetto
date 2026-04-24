package niccolosorrenti.u5d15_progetto.services;

import niccolosorrenti.u5d15_progetto.entities.Evento;
import niccolosorrenti.u5d15_progetto.entities.Prenotazione;
import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.repositories.EventoRepository;
import niccolosorrenti.u5d15_progetto.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    private final EventoRepository eventoRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, EventoRepository eventoRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.eventoRepository = eventoRepository;
    }

    public Prenotazione creaPrenotazione(Utente utente, UUID eventoId, int posti) {

        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento non trovato"));

        if (evento.getPostiDisponibili() < posti) {
            throw new RuntimeException("Posti insufficienti");
        }

        //aggiorna posti disponibili
        evento.setPostiDisponibili(evento.getPostiDisponibili() - posti);
        eventoRepository.save(evento);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setEvento(evento);
        prenotazione.setPostiPrenotati(posti);
        prenotazione.setDataPrenotazione(LocalDate.now());

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> prenotazioniUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }

    public List<Prenotazione> prenotazioniEvento(Evento evento) {
        return prenotazioneRepository.findByEvento(evento);
    }
}
