package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PrenotazioneDTO {
    private UUID eventoId;
    private int postiPrenotati;
}
