package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.Objects;

public class MedicinskaSestra extends Osoblje {
    private Doktor doktorOpsteMedicine;
    private Doktor hirurg;

    public MedicinskaSestra(int godine, String ime, String prezime, Doktor hirurg, Doktor doktorOpsteMedicine) {
        super(godine, ime, prezime, Pozicija.MEDICINSKA_SESTRA);
        this.doktorOpsteMedicine = doktorOpsteMedicine;
        this.hirurg = hirurg;
    }

    public MedicinskaSestra(Osoba o, Doktor hirurg, Doktor doktorOpsteMedicine) {
        super(o, Pozicija.MEDICINSKA_SESTRA);
        this.doktorOpsteMedicine = doktorOpsteMedicine;
        this.hirurg = hirurg;
    }

    public Doktor getDoktorOpsteMedicine() {
        return doktorOpsteMedicine;
    }

    public void setDoktorOpsteMedicine(Doktor doktorOpsteMedicine) {
        this.doktorOpsteMedicine = doktorOpsteMedicine;
    }

    public Doktor getHirurg() {
        return hirurg;
    }

    public void setHirurg(Doktor hirurg) {
        this.hirurg = hirurg;
    }

    @Override
    public void obradiPacijenta(Pacijent p) {
        char prvoSlovo = p.getDijagnoza().charAt(0);
        if (prvoSlovo == 'x' || prvoSlovo == 'X') {
            hirurg.getPacijenti().add(p);
        } else if (prvoSlovo == 'y' || prvoSlovo == 'Y') {
            doktorOpsteMedicine.getPacijenti().add(p);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Medicinska sestra \n");

        sb.append("Doktor opste medicine: ").append(doktorOpsteMedicine.getIme()).append(" ")
                .append(doktorOpsteMedicine.getPrezime()).append("\n");

        sb.append("Hirurg: ").append(hirurg.getIme()).append(" ").append(hirurg.getPrezime()).append(" ");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MedicinskaSestra that = (MedicinskaSestra) o;
        return Objects.equals(doktorOpsteMedicine, that.doktorOpsteMedicine) && Objects.equals(hirurg, that.hirurg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doktorOpsteMedicine, hirurg);
    }

    @Override
    public MedicinskaSestra clone() throws CloneNotSupportedException {
        return new MedicinskaSestra(this, doktorOpsteMedicine, hirurg);
    }
}
