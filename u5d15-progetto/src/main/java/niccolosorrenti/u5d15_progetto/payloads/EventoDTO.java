package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EventoDTO {

    private String titolo;
    private String descrizione;
    private LocalDate dataEvento;
    private String luogo;
    private int postiTotali;
}
