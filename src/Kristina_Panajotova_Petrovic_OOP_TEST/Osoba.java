package Kristina_Panajotova_Petrovic_OOP_TEST;

import java.util.Objects;

public class Osoba implements Cloneable {
    private String ime;
    private String prezime;
    private int godine;

    public Osoba(int godine, String ime, String prezime) {
        this.godine = Math.max(godine, 0);
        this.ime = (ime != null) ? ime : "";
        this.prezime = (prezime != null) ? prezime : "";
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void prikaziInformacije() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Osoba: " +
                "ime: " + ime +
                "prezime: " + prezime +
                "godine: " + godine + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return godine == osoba.godine && Objects.equals(ime, osoba.ime) && Objects.equals(prezime, osoba.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, godine);
    }

    @Override
    public Osoba clone() throws CloneNotSupportedException {
        return (Osoba) super.clone();
    }
}
