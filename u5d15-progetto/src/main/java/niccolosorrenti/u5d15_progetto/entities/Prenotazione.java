package niccolosorrenti.u5d15_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prenotazione_id")
    @Setter(AccessLevel.NONE)
    private UUID prenotazioneId;

    private int postiPrenotati;

    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Prenotazione(int postiPrenotati, LocalDate dataPrenotazione, Utente utente, Evento evento) {
        this.postiPrenotati = postiPrenotati;
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.evento = evento;
    }
}
