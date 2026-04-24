package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import niccolosorrenti.u5d15_progetto.entities.Ruolo;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtenteRespDTO {

    private UUID id;
    private String nome;
    private String email;
    private Ruolo ruolo;
}
