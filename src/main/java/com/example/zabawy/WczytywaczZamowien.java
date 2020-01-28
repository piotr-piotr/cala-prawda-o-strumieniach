package com.example.zabawy;

import com.example.zabawy.helpery.GeneratorLosowychZamowien;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class WczytywaczZamowien implements Spliterator<Zamowienie> {
    private int kursor;
    private final int doIlu;
    private final Zamowienie[] zamówienia;

    public WczytywaczZamowien() {
        zamówienia = new Zamowienie[700]; // jeśli zrobimy za mało zamówień, to strumień nie będzie działał równolegle, nawet jeśli zrobimy mu parallel()
        for (int i = 0; i < 700; i++) {
            zamówienia[i] = GeneratorLosowychZamowien.dajLosoweZamówienie();
        }
        kursor = 0;
        doIlu = zamówienia.length;
    }

    public WczytywaczZamowien(Zamowienie[] zamówienia, int odIlu, int doIlu) {
        this.kursor = odIlu;
        this.doIlu = doIlu;
        this.zamówienia = zamówienia;
    }

    public Zamowienie[] wczytajZamówienia() {
        return zamówienia;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Zamowienie> action) {
        if (kursor < doIlu) {
            action.accept(zamówienia[kursor++]);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Zamowienie> trySplit() {
        System.out.println("    robię split, mój rozmiar to " + estimateSize() + ", wątek=" + Thread.currentThread().getId());
        int środek = kursor + (doIlu - kursor) / 2;
        if (środek == doIlu || środek == doIlu) {
            return null;
        }
        int staryKursor = kursor;
        kursor = środek;
        return new WczytywaczZamowien(zamówienia, staryKursor, środek);
    }

    @Override
    public long estimateSize() {
        return doIlu - kursor;
    }

    @Override
    public int characteristics() {
        return SUBSIZED | SIZED | NONNULL;
    }
}
