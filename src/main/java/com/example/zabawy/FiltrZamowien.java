package com.example.zabawy;

import java.util.Iterator;
import java.util.function.Predicate;

public class FiltrZamowien implements Iterator<Zamowienie> {
    private final Iterator<Zamowienie> zamówienia;
    private final Predicate<Zamowienie> predykat;
    private Zamowienie wybraneZamówienie;

    public FiltrZamowien(Iterator<Zamowienie> zamówienia, Predicate<Zamowienie> predykat) {
        this.zamówienia = zamówienia;
        this.predykat = predykat;
        weźKolejnePasująceZamówienie();
    }

    private void weźKolejnePasująceZamówienie() {
        Zamowienie znalezione = null;
        while (zamówienia.hasNext()) {
            Zamowienie z = zamówienia.next();
            if (predykat.test(z)) {
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
