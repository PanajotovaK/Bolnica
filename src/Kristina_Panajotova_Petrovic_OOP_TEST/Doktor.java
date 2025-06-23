package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doktor extends Osoblje {
    private RadnoMesto radnoMesto;
    private List<Pacijent> pacijenti;
    private List<MedicinskaSestra> medicinskeSestre;

    public Doktor(int godine, String ime, String prezime, List<MedicinskaSestra> medicinskeSestre, List<Pacijent> pacijenti, RadnoMesto radnoMesto) throws CloneNotSupportedException {
        super(godine, ime, prezime, Pozicija.DOKTOR);
        this.medicinskeSestre = medicinskeSestre;
        this.pacijenti = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            this.pacijenti.add(p.clone());
        }
        this.radnoMesto = radnoMesto;
    }

    public Doktor(Osoba o, Pozicija pozicija, List<MedicinskaSestra> medicinskeSestre, List<Pacijent> pacijenti, RadnoMesto radnoMesto) throws CloneNotSupportedException {
        super(o, Pozicija.DOKTOR);
        this.medicinskeSestre = medicinskeSestre;
        this.pacijenti = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            this.pacijenti.add(p.clone());
        }
        this.radnoMesto = radnoMesto;
    }

    public List<MedicinskaSestra> getMedicinskeSestre() {
        return medicinskeSestre;
    }

    public void setMedicinskeSestre(List<MedicinskaSestra> medicinskeSestre) {
        this.medicinskeSestre = medicinskeSestre;
    }

    public List<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    public RadnoMesto getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(RadnoMesto radnoMesto) {
        this.radnoMesto = radnoMesto;
    }

    @Override
    public void obradiPacijenta(Pacijent p) {
        if (!p.isObradjen()) {
            System.out.println("Pacijent:" + p.getIme() + " " + p.getPrezime() + " " +
                    "godine: " + p.getGodine() + " dijagnoza: " + p.getDijagnoza() + " hitnost: " + p.getHitnost());
            if (radnoMesto == RadnoMesto.OPSTA_MEDICINA) {
                System.out.println("obradjen");
            } else if (radnoMesto == RadnoMesto.HIRURGIJA) {
                System.out.println("operisan");

            }
            p.setObradjen(true);
        }
    }

    public void obradiSvePacijente() {
        pacijenti.sort((p1, p2) -> p2.getHitnost().ordinal() - p1.getHitnost().ordinal());
        for (Pacijent p : pacijenti) {
            obradiPacijenta(p);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" , radno mesto: ").append(radnoMesto).append("\n");

        sb.append("MEdicinske sestre: \n");
        for (MedicinskaSestra s : medicinskeSestre) {
            sb.append(s.toString()).append("\n");
        }

        sb.append("Pacijenti: \n");
        for (Pacijent p : pacijenti) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doktor doktor = (Doktor) o;
        return radnoMesto == doktor.radnoMesto && Objects.equals(pacijenti, doktor.pacijenti) && Objects.equals(medicinskeSestre, doktor.medicinskeSestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radnoMesto, pacijenti, medicinskeSestre);
    }
}
