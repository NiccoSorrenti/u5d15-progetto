package niccolosorrenti.u5d15_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utente_id")
    @Setter(AccessLevel.NONE)
    private UUID utenteId;

    private String nome;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;


    public Utente(String nome, String email, String password, Ruolo ruolo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
    }
}
