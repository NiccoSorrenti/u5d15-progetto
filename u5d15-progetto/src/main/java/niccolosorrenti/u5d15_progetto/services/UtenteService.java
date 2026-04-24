package niccolosorrenti.u5d15_progetto.services;

import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Optional<Utente> findUtenteById(UUID id) {
        return utenteRepository.findById(id);
    }

    public Optional<Utente> findUtenteByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }
}
