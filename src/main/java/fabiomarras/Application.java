package fabiomarras;

import fabiomarras.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        EventoDAO sd = new EventoDAO(em);
        PersonDAO pd = new PersonDAO(em);
        PartecipazioneDAO ppd = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);

        // SAVE per salvare un nuovo evento
        Person Fabio = new Person("Fabio","Marras", "fabio@gmail.com" , LocalDate.now(),Genres.M);
        //pd.save(Fabio);
            Partecipazione p1 = new Partecipazione(Status.DA_CONFERMARE);
            //ppd.save(p1);
            Location l1 = new Location("CagliariCircuit", "Cagliari");
            //ld.save(l1);

           /* Person findById = pd.findById(UUID.fromString("d3c826fc-afb1-4554-92a8-80cbe4636a23"));
            if (findById != null) {
                System.out.println(findById);
            } else {
                System.out.println("non ho trovato niente");
            }*/

        //pd.findByIdAndDelete(UUID.fromString("d3c826fc-afb1-4554-92a8-80cbe4636a23"));


        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
        em.close();
        emf.close();
        }
    }
}
