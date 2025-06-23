package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalterskiSluzbenik extends Osoblje {

    private List<Pacijent> pacijenti;

    public SalterskiSluzbenik(int godine, String ime, String prezime, List<Pacijent> pacijenti) throws CloneNotSupportedException {
        super(godine, ime, prezime, Pozicija.SALTERSKI_SLUZBENIK);
        this.pacijenti = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            this.pacijenti.add(p.clone());
        }
    }

    public SalterskiSluzbenik(Osoba o, List<Pacijent> pacijenti) throws CloneNotSupportedException {
        super(o, Pozicija.SALTERSKI_SLUZBENIK);
        this.pacijenti = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            this.pacijenti.add(p.clone());
        }
    }

    public List<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalterskiSluzbenik that = (SalterskiSluzbenik) o;
        return Objects.equals(pacijenti, that.pacijenti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pacijenti);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getIme()).append(" ").append(getPrezime()).append("Godine, Salterski sluzbenik \n ");

        for (Pacijent p : pacijenti) {
            sb.append("Ime: ").append(p.getIme()).append(" Prezime: ").append(p.getPrezime())
                    .append("Godine: ").append(p.getGodine()).append("\n").append("Dijagniza: ").append(p.getDijagnoza())
                    .append("\n ").append("Hitnost: ").append(p.getHitnost()).append("\n");
        }
        return sb.toString();

    }

    public void povecajHitnost(Pacijent p) {
        p.setHitnost(p.getHitnost().povecajHitnost());
    }

    @Override
    public void obradiPacijenta(Pacijent p) {
        if (!p.isObradjen() && (p.getDijagnoza().charAt(0) == 'x' || p.getDijagnoza().charAt(0) == 'X')) {
            povecajHitnost(p);
        }

    }

    public void smanjiHitnost(Pacijent p) {
        p.setHitnost(p.getHitnost().smanjiHitnost());
    }

    public Pacijent najhitnijiPacijent() {
        if ((pacijenti.isEmpty())) return null;

        Pacijent najhitniji = null;
        for (Pacijent p : pacijenti) {
            if (najhitniji == null || p.getHitnost().ordinal() > najhitniji.getHitnost().ordinal()) {
                najhitniji = p;
            }
        }
        if ((najhitniji != null)) {
            pacijenti.remove(najhitniji);
        }
        return najhitniji;
    }


}
