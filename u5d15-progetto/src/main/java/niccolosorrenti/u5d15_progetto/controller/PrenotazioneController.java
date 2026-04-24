package niccolosorrenti.u5d15_progetto.controller;

import niccolosorrenti.u5d15_progetto.entities.Prenotazione;
import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.payloads.PrenotazioneDTO;
import niccolosorrenti.u5d15_progetto.payloads.PrenotazioneRespDTO;
import niccolosorrenti.u5d15_progetto.services.PrenotazioneService;
import niccolosorrenti.u5d15_progetto.services.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final UtenteService utenteService;

    public PrenotazioneController(PrenotazioneService prenotazioneService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
        this.utenteService = utenteService;
    }

    @PostMapping("/{utenteId}")
    public PrenotazioneRespDTO prenota(@PathVariable UUID utenteId, @RequestBody PrenotazioneDTO dto) {

        Utente utente = utenteService.findUtenteById(utenteId).orElseThrow(() -> new RuntimeException("Utente non trovato"));

        Prenotazione prenotazione = prenotazioneService.creaPrenotazione(
                utente,
                dto.getEventoId(),
                dto.getPostiPrenotati()
        );

        PrenotazioneRespDTO response = new PrenotazioneRespDTO();
        response.setId(prenotazione.getPrenotazioneId());
        response.setPostiPrenotati(prenotazione.getPostiPrenotati());
        response.setDataPrenotazione(prenotazione.getDataPrenotazione());
        response.setUtenteId(utente.getUtenteId());
        response.setEventoId(prenotazione.getEvento().getEventoId());

        return response;
    }
}
