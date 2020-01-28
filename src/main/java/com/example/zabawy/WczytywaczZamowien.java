package com.example.zabawy;

import com.example.zabawy.helpery.GeneratorLosowychZamowien;

public class WczytywaczZamowien {
    private final Zamowienie[] zamówienia;
    {
        zamówienia = new Zamowienie[300];
        for (int i = 0; i < 300; i++) {
            zamówienia[i] = GeneratorLosowychZamowien.dajLosoweZamówienie();
        }
    }

    public Zamowienie[] wczytajZamówienia() {
        return zamówienia;
    }
}
