package fabiomarras.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status Status;

    @ManyToMany
    @JoinTable(name = "person_partecipazione", joinColumns = @JoinColumn(name = "partecipazione_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> person;
    @ManyToMany
    @JoinTable(name = "partecipazione_event", joinColumns = @JoinColumn(name = "partecipazione_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Evento> event;

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

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }


    @Override
    public String toString() {
        return "Partecipazione{" +
                "Status=" + Status +
                ", person=" + person +
                '}';
    }
}
