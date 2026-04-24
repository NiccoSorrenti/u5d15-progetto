package niccolosorrenti.u5d15_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    @Setter(AccessLevel.NONE)
    private UUID eventoId;

    private String titolo;

    private String descrizione;

    private LocalDate dataEvento;

    private String luogo;

    private int postiTotali;

    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizzatore_id")
    private Utente organizzatore;

    public Evento(String titolo, String descrizione, LocalDate dataEvento, String luogo, int postiTotali, int postiDisponibili, Utente organizzatore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataEvento = dataEvento;
        this.luogo = luogo;
        this.postiTotali = postiTotali;
        this.postiDisponibili = postiDisponibili;
        this.organizzatore = organizzatore;
    }
}
