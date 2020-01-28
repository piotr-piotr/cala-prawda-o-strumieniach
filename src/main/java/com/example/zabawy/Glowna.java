package com.example.zabawy;

import java.util.Iterator;

public class Glowna {
    public static void main(String[] args) {
        WczytywaczZamowien wczytywaczZamowien = new WczytywaczZamowien();
        Iterator<Zamowienie> zamówieniaUSD = new PrzeliczaczNaDolary(wczytywaczZamowien, 4.25);
        Iterator<Zamowienie> zamówieniaMałeUSD = new FiltrWybierajacyMaleZamowienia(zamówieniaUSD);
//        wyświetlZamówienia(zamówieniaMałeUSD); // nie mogę jednocześnie i wyświetlić tych zamówień, i ich podsumować
        int suma = SumatorZamowien.sumujZamówienia(zamówieniaMałeUSD);
        System.out.println(suma);
    }

    private static void wyświetlZamówienia(Iterator<Zamowienie> zamówienia) {
        while (zamówienia.hasNext()) {
            System.out.println(zamówienia.next());
        }
    }
}
