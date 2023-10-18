package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class PersonDAO {
    private  final EntityManager em;
    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Person s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Persona registrata con successo!!");
    }

    //METODO FIND per id
    public Person findById(UUID id){
        return em.find(Person.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public void findByIdAndDelete(UUID id){
        Person found = em.find(Person.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Persona rimossa con successo!");
        }
    }
}
