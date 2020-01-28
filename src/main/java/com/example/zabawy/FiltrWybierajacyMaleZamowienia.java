package com.example.zabawy;

import java.util.Iterator;

public class FiltrWybierajacyMaleZamowienia implements Iterator<Zamowienie> {
    private final Iterator<Zamowienie> zamówienia;
    private Zamowienie wybraneZamówienie;

    public FiltrWybierajacyMaleZamowienia(Iterator<Zamowienie> zamówienia) {
        this.zamówienia = zamówienia;
        weźKolejnePasująceZamówienie();
    }

    private void weźKolejnePasująceZamówienie() {
        Zamowienie znalezione = null;
        while (zamówienia.hasNext()) {
            Zamowienie z = zamówienia.next();
            if (z.getIleSztuk() < 6) {
                znalezione = z;
                break;
            }
        }
        wybraneZamówienie = znalezione;
    }

    @Override
    public boolean hasNext() {
        return wybraneZamówienie != null;
    }

    @Override
    public Zamowienie next() {
        Zamowienie z = this.wybraneZamówienie;
        weźKolejnePasująceZamówienie();
        return z;
    }
}
