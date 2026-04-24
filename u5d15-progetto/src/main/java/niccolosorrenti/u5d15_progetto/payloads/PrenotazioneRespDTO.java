package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneRespDTO {

    private UUID id;
    private int postiPrenotati;
    private LocalDate dataPrenotazione;
    private UUID utenteId;
    private UUID eventoId;
}
