package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class PartecipazioneDAO {
    private  final EntityManager em;
    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Partecipazione s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Partecipazione registrata con successo!!");
    }

    //METODO FIND per id
    public Partecipazione findById(UUID id){
        return em.find(Partecipazione.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public void findByIdAndDelete(UUID id){
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Partecipazione rimossa con successo!");
        }
    }
}
