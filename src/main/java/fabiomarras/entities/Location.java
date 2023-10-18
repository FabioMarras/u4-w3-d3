package fabiomarras.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String city;

    public Location(){}

    @ManyToMany
    @JoinTable(name = "event_location", joinColumns = @JoinColumn(name = "location_id"),
    inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Evento> events;

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Evento> getEvents() {
        return events;
    }

    public void setEvents(List<Evento> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
