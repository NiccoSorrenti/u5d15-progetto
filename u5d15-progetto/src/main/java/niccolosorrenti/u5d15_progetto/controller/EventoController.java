package niccolosorrenti.u5d15_progetto.controller;

import niccolosorrenti.u5d15_progetto.entities.Evento;
import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.payloads.EventoDTO;
import niccolosorrenti.u5d15_progetto.payloads.EventoRespDTO;
import niccolosorrenti.u5d15_progetto.services.EventoService;
import niccolosorrenti.u5d15_progetto.services.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventi")
public class EventoController {

    private final EventoService eventoService;
    private final UtenteService utenteService;

    public EventoController(EventoService eventoService, UtenteService utenteService) {
        this.eventoService = eventoService;
        this.utenteService = utenteService;
    }

    @PostMapping("/{organizzatoreId}")
    public EventoRespDTO creaEvento(@PathVariable UUID organizzatoreId, @RequestBody EventoDTO dto) {

        Utente organizzatore = utenteService.findUtenteById(organizzatoreId).orElseThrow(() -> new RuntimeException("Organizzatore non trovato"));

        Evento evento = new Evento(
                dto.getTitolo(),
                dto.getDescrizione(),
                dto.getDataEvento(),
                dto.getLuogo(),
                dto.getPostiTotali(),
                dto.getPostiTotali(),
                organizzatore
        );

        Evento salvato = eventoService.creaEvento(evento, organizzatore);

        EventoRespDTO response = new EventoRespDTO();
        response.setId(salvato.getEventoId());
        response.setTitolo(salvato.getTitolo());
        response.setDescrizione(salvato.getDescrizione());
        response.setDataEvento(salvato.getDataEvento());
        response.setLuogo(salvato.getLuogo());
        response.setPostiTotali(salvato.getPostiTotali());
        response.setPostiDisponibili(salvato.getPostiDisponibili());
        response.setOrganizzatoreId(organizzatore.getUtenteId());

        return response;
    }

    @GetMapping
    public List<EventoRespDTO> getAllEventi() {
        return eventoService.getTuttiEventi()
                .stream()
                .map(e -> {
                    EventoRespDTO dto = new EventoRespDTO();
                    dto.setId(e.getEventoId());
                    dto.setTitolo(e.getTitolo());
                    dto.setDescrizione(e.getDescrizione());
                    dto.setDataEvento(e.getDataEvento());
                    dto.setLuogo(e.getLuogo());
                    dto.setPostiTotali(e.getPostiTotali());
                    dto.setPostiDisponibili(e.getPostiDisponibili());
                    dto.setOrganizzatoreId(e.getOrganizzatore().getUtenteId());
                    return dto;
                }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminaEvento(@PathVariable UUID id) {
        eventoService.eliminaEvento(id);
    }
}
