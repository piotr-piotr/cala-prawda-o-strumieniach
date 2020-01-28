package com.example.zabawy;

import java.util.Iterator;

public class SumatorZamowien {
    public static int sumujZamówienia(Iterator<Zamowienie> zamówienia) {
        int suma = 0;
        while (zamówienia.hasNext()) {
            Zamowienie zamówienie = zamówienia.next();
            suma += zamówienie.getCena() * zamówienie.getIleSztuk();
        }
        return suma;
    }
}
