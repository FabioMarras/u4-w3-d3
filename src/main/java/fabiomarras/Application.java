package fabiomarras;

import fabiomarras.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;

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
        Person Fabio = new Person("Alfonso","Marras", "fabio@gmail.com" , LocalDate.now(),Genres.M);
        //pd.save(Fabio);
            Partecipazione p1 = new Partecipazione(Status.DA_CONFERMARE);
            //ppd.save(p1);
            Location l1 = new Location("Spa", "Belgio");
            //ld.save(l1);

            /*Evento findById = sd.findById(UUID.fromString("a96753a2-1e80-4798-850c-ad81f7aaf8eb"));
            if (findById != null) {
                System.out.println(findById);
            } else {
                System.out.println("non ho trovato niente");
            }*/

        //pd.findByIdAndDelete(UUID.fromString("d3c826fc-afb1-4554-92a8-80cbe4636a23"));

           //Location cagliari = ld.findById(UUID.fromString("4720ab9d-670b-4a15-bc1a-16f5c85002f5"));
           Location belgio = ld.findById(UUID.fromString("bba346e8-0cd2-4569-b6ce-b9346e824b65"));

           Evento race = sd.findById(UUID.fromString("a96753a2-1e80-4798-850c-ad81f7aaf8eb"));

            if (belgio != null) {
                race.setLocations(new HashSet<>(Arrays.asList(belgio)));
                sd.save(race);
            }

            System.out.println("Location per l'evento race: ");
            race.getLocations().forEach(System.out::println);

            System.out.println("Evento per la gara in belgio: ");
            belgio.getEvents().forEach(System.out::println);

            Person fabio = pd.findById(UUID.fromString("414cf218-fe29-4fe1-b1b6-e56c6351cafb"));
            Person alfonso = pd.findById(UUID.fromString("40a3ca6b-e033-42c3-9e59-eca5f511ff37"));
            Partecipazione frompublic = ppd.findById(UUID.fromString("227bcb90-517d-4204-970f-3ddd029847cf"));
            Partecipazione frompublic1 = ppd.findById(UUID.fromString("227bcb90-517d-4204-970f-3ddd029847cf"));

            if (fabio != null) {
                frompublic.setPerson(new HashSet<>(Arrays.asList(fabio, alfonso)));
                ppd.save(frompublic);
            }
            /*if (alfonso != null) {
                frompublic1.setPerson(new HashSet<>(Arrays.asList(alfonso)));
                ppd.save(frompublic1);
            }*/

            System.out.println("Partecipazioni per l'evento: ");
            frompublic.getPerson().forEach(System.out::println);
            frompublic1.getPerson().forEach(System.out::println);

            if (fabio != null ) {
                race.setPartecipazione(new HashSet<>(Arrays.asList(frompublic)));
                ppd.save(frompublic);
            }

            System.out.println("Questo è il dettaglio di race: ");
            System.out.println(race);

            /*Evento race1 = sd.findById(UUID.fromString("a96753a2-1e80-4798-850c-ad81f7aaf8eb"));

            if (race1 != null ) {
                fabio.setEvent(new HashSet<>(Arrays.asList(race1)));
                pd.save(fabio);
            } else {
                System.out.println("ops non c'è quest'evento");
            }

            System.out.println("Partecipazioni di fabio: ");
            fabio.getEvent().forEach(System.out::println);*/

            /*if (fabio != null) {
                race.setPerson(new HashSet<>(Arrays.asList(fabio)));
                sd.save(race);
            }

            System.out.println("Persone presenti per l'evento race: ");
            race.getPerson().forEach(System.out::println);*/

        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
        em.close();
        emf.close();
        }
    }
}
