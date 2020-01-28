package com.example.zabawy;

import java.util.Iterator;
import java.util.function.Function;

public class MaperZamowien implements Iterator<Zamowienie> {
    private final Iterator<Zamowienie> zamówienia;
    private final Function<Zamowienie, Zamowienie> mapowanie;

    public MaperZamowien(Iterator<Zamowienie> zamówienia, Function<Zamowienie, Zamowienie> mapowanie) {
        this.zamówienia = zamówienia;
        this.mapowanie = mapowanie;
    }

    @Override
    public boolean hasNext() {
        return zamówienia.hasNext();
    }

    @Override
    public Zamowienie next() {
        return mapowanie.apply(zamówienia.next());
    }
}
