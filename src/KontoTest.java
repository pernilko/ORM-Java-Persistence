import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class KontoTest {

    public static void main(String[]args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
        KontoDAO dao = new KontoDAO(emf);

        //Oppgave 2

        try {
            //Oppretter og legger inn to kontoer i db
            Konto k1 = new Konto("123456", 3336.9, "Pernille");
            Konto k2 = new Konto("789012", 9999.0, "Runa");
            dao.opprettKonto(k1);
            dao.opprettKonto(k2);

            //Finner kontoer med saldo >= et spesifikt beløp
            ArrayList<Konto> kontoer = dao.finnKontoerMedSaldoStorreEnn(4000.0);
            for (Konto k : kontoer) {
                System.out.println(k.toString());
            }

            //Endrer eier på en konto
            dao.endreEier("Petter", k1);
        }finally {
            emf.close();
        }
    }
}
