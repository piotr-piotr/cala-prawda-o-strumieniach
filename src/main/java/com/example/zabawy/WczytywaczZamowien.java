package com.example.zabawy;

import com.example.zabawy.helpery.GeneratorLosowychZamowien;

import java.util.Iterator;

public class WczytywaczZamowien implements Iterator<Zamowienie> {
    private int kursor = 0;

    private final Zamowienie[] zamówienia;
    {
        zamówienia = new Zamowienie[300];
        for (int i = 0; i < 300; i++) {
            zamówienia[i] = GeneratorLosowychZamowien.dajLosoweZamówienie();
        }
    }

    public Zamowienie next() {
        return zamówienia[kursor++];
    }

    public boolean hasNext() {
        return kursor < zamówienia.length;
    }

    public Zamowienie[] wczytajZamówienia() {
        return zamówienia;
    }
}
