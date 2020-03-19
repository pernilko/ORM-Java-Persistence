import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.*;

@Entity
public class Konto {

    @Id
    @Column(name="kontonr")
    String kontonr;

    double saldo;
    String eier;

    public Konto(String kontonr, double saldo, String eier){

        this.kontonr = kontonr;
        this.saldo = saldo;
        this.eier = eier;

    }

    //get- og set-metoder
    public double getSaldo() {return saldo;}
    public String getEier() {return eier;}
    public String getKontonr() { return kontonr;}
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
