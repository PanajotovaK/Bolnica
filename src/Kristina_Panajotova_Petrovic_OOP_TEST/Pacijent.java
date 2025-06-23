package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.Objects;

public class Pacijent extends Osoba implements Cloneable {
    private String dijagnoza;
    private Hitnost hitnost;
    private boolean obradjen;

    public Pacijent(int godine, String ime, String prezime, String dijagnoza, Hitnost hitnost) {
        super(godine, ime, prezime);
        this.dijagnoza = dijagnoza;
        this.hitnost = hitnost;
        this.obradjen = false;
    }

    public Pacijent(Osoba o, String dijagnoza, Hitnost hitnost) {
        super(o.getGodine(), o.getPrezime(), o.getIme());
        this.dijagnoza = dijagnoza;
        this.hitnost = hitnost;
        this.obradjen = false;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public Hitnost getHitnost() {
        return hitnost;
    }

    public void setHitnost(Hitnost hitnost) {
        this.hitnost = hitnost;
    }

    public boolean isObradjen() {
        return obradjen;
    }

    public void setObradjen(boolean obradjen) {
        this.obradjen = obradjen;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime() + ", " + getGodine() + " godina, dijagnoza: " + dijagnoza +
                " hitnost: " + hitnost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pacijent pacijent = (Pacijent) o;
        return obradjen == pacijent.obradjen && Objects.equals(dijagnoza, pacijent.dijagnoza) && hitnost == pacijent.hitnost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dijagnoza, hitnost, obradjen);
    }

    @Override
    public Pacijent clone() throws CloneNotSupportedException {
        return new Pacijent(getGodine(), getPrezime(), getIme(), new String(dijagnoza), hitnost);
    }
}
