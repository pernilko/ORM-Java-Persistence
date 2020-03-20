import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Konto {

    @Id
    @Column(name="kontonr")
    String kontonr;

    @Version
    @Column(name = "lock_var")
    private int lock;

    double saldo;
    String eier;

    public Konto(){

    }

    public Konto(String kontonr, double saldo, String eier){

        this.kontonr = kontonr;
        this.saldo = saldo;
        this.eier = eier;
        this.lock = 0;

    }

    public Konto(String kontonr, int lock, double saldo, String eier){
        this.kontonr = kontonr;
        this.saldo = saldo;
        this.eier = eier;
        this.lock = lock;

    }

    //get- og set-metoder
    public double getSaldo() {return saldo;}
    public String getEier() {return eier;}
    public String getKontonr() { return kontonr;}
    public int getLock() { return lock;}
    public void setLock(int lock) { this.lock = lock;}
    public void setEier(String eier) { this.eier = eier;}
    public void setKontonr(String kontonr) { this.kontonr = kontonr;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

    @Override
    public String toString() {
        return "Konto{" +
                "kontonr='" + kontonr + '\'' +
                ", saldo=" + saldo +
                ", eier='" + eier + '\'' +
                '}';
    }

    public void trekkBelop(double belop){
        this.saldo -= belop;
    }
}
