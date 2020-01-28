package com.example.zabawy;

import java.util.Iterator;

public class PrzeliczaczNaDolary implements Iterator<Zamowienie> {
    private final Iterator<Zamowienie> zamówienia;
    private final double kursDolara;

    public PrzeliczaczNaDolary(Iterator<Zamowienie> zamówienia, double kursDolara) {
        this.zamówienia = zamówienia;
        this.kursDolara = kursDolara;
    }

    @Override
    public boolean hasNext() {
        return zamówienia.hasNext();
    }

    @Override
    public Zamowienie next() {
        Zamowienie zamówieniePLN = zamówienia.next();
        Zamowienie zamówienieUSD = new Zamowienie(zamówieniePLN.getId(), (int) (zamówieniePLN.getCena() / kursDolara), zamówieniePLN.getIleSztuk());
        return zamówienieUSD;
    }
}
