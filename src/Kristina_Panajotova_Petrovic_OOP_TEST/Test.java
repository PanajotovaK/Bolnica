package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        Pacijent p1 = new Pacijent(32, "Marko", "Markovic", "xSrce", Hitnost.ZELENO);
        Pacijent p2 = new Pacijent(54, "Jovana", "Jovanovic", "yGlava", Hitnost.ZELENO);

        List<Pacijent> sviPacijenti = new ArrayList<>();
        sviPacijenti.add(p1);
        sviPacijenti.add(p2);

        SalterskiSluzbenik ss1 = new SalterskiSluzbenik(25, "Petar", "Petrovic", new ArrayList<>());
        SalterskiSluzbenik ss2 = new SalterskiSluzbenik(58, "Marija", "MArkovic", new ArrayList<>());

        Doktor doktorOpste1 = new Doktor(49, "Nikola", "Kocic", new ArrayList<>(), new ArrayList<>(), RadnoMesto.OPSTA_MEDICINA);
        Doktor hirurg1 = new Doktor(37, "Milica", "PEtrovic", new ArrayList<>(), new ArrayList<>(), RadnoMesto.HIRURGIJA);

        MedicinskaSestra ms1 = new MedicinskaSestra(21, "Jana", "Jankovic", hirurg1, doktorOpste1);
        MedicinskaSestra ms2 = new MedicinskaSestra(29, "Sanja", "Jovic", hirurg1, doktorOpste1);

        doktorOpste1.getMedicinskeSestre().add(ms1);
        hirurg1.getMedicinskeSestre().add(ms2);

        List<Osoblje> osoblje = new ArrayList<>();
        osoblje.add(ss1);
        osoblje.add(ss2);
        osoblje.add(doktorOpste1);
        osoblje.add(hirurg1);
        osoblje.add(ms1);
        osoblje.add(ms2);

        Bolnica bolnica = new Bolnica("Klinicki centar", osoblje, sviPacijenti);

        Aplikacija app = new Aplikacija(bolnica);


        System.out.println("Doktor sa najvise pacijenata: " + app.doktorSaNajvisePacijenata());

        System.out.println("Doktor sa najvise sestara: " + app.doktorSaNajviseMedicinskihSestara());

        System.out.println("Broj pacijenata za hirurgiju: " + app.brojPacijenataZaHirurgiju());

        System.out.println("Broj pacijenata za opstu medicinu: " + app.brojPacijenataZaOpstuMedicinu());


        Pacijent najhitniji = app.najhitnijiPAcijent();
        System.out.println("Najhitniji pacijent : " + najhitniji);

        System.out.println("Obrada preostalih pacijenata: ");
        while (bolnica.getPacijenti().isEmpty()) {
            app.proslediSledecegPacijenta();
        }


    }
}
