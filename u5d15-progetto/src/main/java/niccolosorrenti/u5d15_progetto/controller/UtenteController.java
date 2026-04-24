package niccolosorrenti.u5d15_progetto.controller;

import niccolosorrenti.u5d15_progetto.entities.Utente;
import niccolosorrenti.u5d15_progetto.payloads.UtenteDTO;
import niccolosorrenti.u5d15_progetto.payloads.UtenteRespDTO;
import niccolosorrenti.u5d15_progetto.services.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping
    public UtenteRespDTO creaUtente(@RequestBody UtenteDTO dto) {

        Utente utente = new Utente(
                dto.getNome(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRuolo()
        );

        Utente salvato = utenteService.salvaUtente(utente);

        UtenteRespDTO response = new UtenteRespDTO();
        response.setId(salvato.getUtenteId());
        response.setNome(salvato.getNome());
        response.setEmail(salvato.getEmail());
        response.setRuolo(salvato.getRuolo());

        return response;
    }

    @GetMapping("/{id}")
    public Utente getById(@PathVariable UUID id) {
        return utenteService.findUtenteById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }
}
