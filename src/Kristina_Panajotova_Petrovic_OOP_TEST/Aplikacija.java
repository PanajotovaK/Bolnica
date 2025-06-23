package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.List;

public class Aplikacija {
    private Bolnica bolnica;
    private int trenutniSalterskiSluzbenik = 0;
    private int trenutnaSestra = 0;

    public Aplikacija(Bolnica bolnica) {
        this.bolnica = bolnica;
    }

    public Bolnica getBolnica() {
        return bolnica;
    }

    public void setBolnica(Bolnica bolnica) {
        this.bolnica = bolnica;
    }

    public Doktor doktorSaNajvisePacijenata() {
        Doktor rezultat = null;
        int max = 1;
        for (Osoblje o : bolnica.getOsoblje()) {
            if (o instanceof Doktor) {
                Doktor d = (Doktor) o;
                if (d.getPacijenti().size() > max) {
                    max = d.getPacijenti().size();
                    rezultat = d;
                }
            }
        }
        return rezultat;
    }

    public Doktor doktorSaNajviseMedicinskihSestara() {
        Doktor rezultat = null;
        int max = 1;
        for (Osoblje o : bolnica.getOsoblje()) {
            if (o instanceof Doktor) {
                Doktor d = (Doktor) o;
                if (d.getMedicinskeSestre().size() > max) {
                    max = d.getMedicinskeSestre().size();
                    rezultat = d;
                }
            }
        }
        return rezultat;
    }

    public int brojPacijenataZaHirurgiju() {
        int count = 0;
        for (Pacijent p : bolnica.getPacijenti()) {
            if (p.getDijagnoza().charAt(0) == 'x' || p.getDijagnoza().charAt(0) == 'X') {
                count++;
            }
        }
        return count;
    }

    public int brojPacijenataZaOpstuMedicinu() {
        int count = 0;
        for (Pacijent p : bolnica.getPacijenti()) {
            if (p.getDijagnoza().charAt(0) == 'y' || p.getDijagnoza().charAt(0) == 'Y') {
                count++;
            }
        }
        return count;
    }

    public Pacijent najhitnijiPAcijent() {
        if (bolnica.getPacijenti().isEmpty()) return null;

        Pacijent najhitniji = null;
        for (Pacijent p : bolnica.getPacijenti()) {
            if (najhitniji == null) {
                najhitniji = p;
            } else {
                boolean trenutniJeHirurgija =
                        p.getDijagnoza().charAt(0) == 'x' ||
                                p.getDijagnoza().charAt(0) == 'X';
                boolean najhitnijiJeHirurgija =
                        najhitniji.getDijagnoza().charAt(0) == 'x' ||
                                najhitniji.getDijagnoza().charAt(0) == 'X';

                if (trenutniJeHirurgija && !najhitnijiJeHirurgija) {
                    najhitniji = p;
                } else if (trenutniJeHirurgija == najhitnijiJeHirurgija) ;
            }

            if (p.getHitnost().compareTo(najhitniji.getHitnost()) > 0) {
                najhitniji = p;
            }
        }

        bolnica.getPacijenti().remove(najhitniji);
        return najhitniji;
    }

    public void proslediSledecegPacijenta() {
        if (bolnica.getPacijenti().isEmpty()) return;

        Pacijent p = bolnica.getPacijenti().get(0);
        bolnica.getPacijenti().remove(0);

        List<Osoblje> osoblje = bolnica.getOsoblje();
        int brOsoblja = osoblje.size();

        while (!(osoblje.get(trenutniSalterskiSluzbenik) instanceof SalterskiSluzbenik)) {
            trenutniSalterskiSluzbenik = (trenutniSalterskiSluzbenik + 1) % brOsoblja;
        }

        SalterskiSluzbenik ss = (SalterskiSluzbenik) osoblje.get(trenutniSalterskiSluzbenik);
        ss.getPacijenti().add(p);
        ss.obradiPacijenta(p);

        while (!(osoblje.get(trenutnaSestra) instanceof MedicinskaSestra)) {
            trenutnaSestra = (trenutnaSestra + 1) % brOsoblja;
        }

        MedicinskaSestra ms = (MedicinskaSestra)
                osoblje.get(trenutnaSestra);
        ms.obradiPacijenta(p);

        trenutniSalterskiSluzbenik = (trenutniSalterskiSluzbenik + 1) % brOsoblja;
        trenutnaSestra = (trenutnaSestra + 1) % brOsoblja;
    }

}