package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.Objects;

public abstract class Osoblje extends Osoba implements Zaposljiv, Cloneable {

    private Pozicija pozicija;

    public Osoblje(int godine, String ime, String prezime, Pozicija pozicija) {
        super(godine, ime, prezime);
        this.pozicija = pozicija;
    }

    public Osoblje(Osoba o, Pozicija pozicija) {
        super(o.getGodine(), o.getIme(), o.getPrezime());
        this.pozicija = pozicija;
    }


    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime() + ", " + getGodine() + " godina, pozicija: " + pozicija + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Osoblje osoblje = (Osoblje) o;
        return pozicija == osoblje.pozicija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pozicija);
    }

    @Override
    public Osoba clone() throws CloneNotSupportedException {
        return (Osoblje) super.clone();
    }
}
