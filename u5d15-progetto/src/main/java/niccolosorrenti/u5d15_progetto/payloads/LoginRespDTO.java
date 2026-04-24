package niccolosorrenti.u5d15_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespDTO {

    private String token;
    private String tipo = "Bearer";
}
