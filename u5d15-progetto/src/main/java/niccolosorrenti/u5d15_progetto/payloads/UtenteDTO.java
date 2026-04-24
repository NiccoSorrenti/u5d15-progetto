package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import niccolosorrenti.u5d15_progetto.entities.Ruolo;

@Getter
@AllArgsConstructor
public class UtenteDTO {

    private String nome;
    private String email;
    private String password;
    private Ruolo ruolo;
}
