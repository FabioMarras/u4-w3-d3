package fabiomarras.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status Status;

    public Partecipazione(){}

    public Partecipazione(fabiomarras.entities.Status status) {
        Status = status;
    }

    public UUID getId() {
        return id;
    }


    public fabiomarras.entities.Status getStatus() {
        return Status;
    }

    public void setStatus(fabiomarras.entities.Status status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", Status=" + Status +
                '}';
    }
}
