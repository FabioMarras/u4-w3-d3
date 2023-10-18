package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class LocationDAO {
    private  final EntityManager em;
    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Location s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Location registrata con successo!!");
    }

    //METODO FIND per id
    public LocationDAO findById(UUID id){
        return em.find(LocationDAO.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public void findByIdAndDelete(UUID id){
        LocationDAO found = em.find(LocationDAO.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Location rimossa con successo!");
        }
    }
}
