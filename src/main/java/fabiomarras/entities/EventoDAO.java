package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class EventoDAO {
    private  final EntityManager em;
    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Evento s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Evento registrato con successo!!");
    }

    //METODO FIND per id
    public Evento findById(UUID id){
        return em.find(Evento.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public  void findByIdAndDelete(UUID id){
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento rimosso con successo!");
        }
    }
}
