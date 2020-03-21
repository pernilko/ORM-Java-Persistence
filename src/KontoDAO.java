import javax.persistence.*;
import java.util.ArrayList;

public class KontoDAO {

    private EntityManagerFactory emf;

    public KontoDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    private void lukkEMF(EntityManager em){
        if(em.isOpen() && em != null){
            em.close();
        }
    }

    public void opprettKonto(Konto k){
        EntityManager em = getEmf();
        em.getTransaction().begin(); //Return EntityTransaction objekt og start transaksjon
        em.persist(k); //opprett konto
        em.getTransaction().commit(); //commit transaksjon
        lukkEMF(em);
    }

    public EntityManager getEmf(){
        return emf.createEntityManager();
    }

    public ArrayList<Konto> finnKontoerMedSaldoStorreEnn(double belop){
        EntityManager em = getEmf();
        try {
            Query q = em.createQuery(
                    "SELECT k FROM Konto k WHERE k.saldo >= :belop");
            q.setParameter("belop", belop);
            ArrayList<Konto> k = new ArrayList<Konto>(q.getResultList());
            return k;
        }finally {
            lukkEMF(em);
        }
    }

    public void endreEier(String nyEier, Konto k){
        EntityManager em = getEmf();
        try {
            em.getTransaction().begin();
            Konto nyKonto = k;
            nyKonto.setEier(nyEier);
            em.merge(nyKonto);
            em.getTransaction().commit();
        }finally {
            lukkEMF(em);
        }
    }

    public void overforing(double belop, String fra, String til){
        EntityManager em = getEmf();
        try {
            Konto fraKonto = em.find(Konto.class,fra);
            Konto tilKonto = em.find(Konto.class,til);

            em.getTransaction().begin();
            fraKonto.trekkBelop(belop);


        }finally {
            lukkEMF(em);
        }
    }


}
