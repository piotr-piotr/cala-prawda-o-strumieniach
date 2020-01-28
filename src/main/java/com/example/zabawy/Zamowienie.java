package com.example.zabawy;

public class Zamowienie {
    private int id;
    private int cena;
    private int ileSztuk;

    public Zamowienie() {
    }
    
    public Zamowienie(int id, int cena, int ileSztuk) {
        this.id = id;
        this.cena = cena;
        this.ileSztuk = ileSztuk;
    }

    public int getId() {
        return id;
    }

    public int getCena() {
        return cena;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.cena;
        hash = 97 * hash + this.ileSztuk;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zamowienie other = (Zamowienie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cena != other.cena) {
            return false;
        }
        if (this.ileSztuk != other.ileSztuk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zam\u00f3wienie{" + "id=" + id + ", cena=" + cena + ", ileSztuk=" + ileSztuk + '}';
    }

    
}
