package com.example.zabawy;

import java.util.Iterator;
import java.util.function.Consumer;

public class Glowna {
    public static void main(String[] args) {
        WczytywaczZamowien wczytywaczZamowien = new WczytywaczZamowien();
        Iterator<Zamowienie> zamówieniaUSD = new MaperZamowien(wczytywaczZamowien, z -> new Zamowienie(z.getId(), (int)(z.getCena() / 4.25), z.getIleSztuk()));
        Iterator<Zamowienie> zamówieniaMałeUSD = new FiltrZamowien(zamówieniaUSD, z -> z.getIleSztuk() < 6);
        forEach(zamówieniaMałeUSD, System.out::println); // nie mogę jednocześnie i wyświetlić tych zamówień, i ich podsumować
//        int suma = SumatorZamowien.sumujZamówienia(zamówieniaMałeUSD);
//        System.out.println(suma);
    }

    private static void forEach(Iterator<Zamowienie> zamówienia, Consumer<Zamowienie> konsumer) {
        while (zamówienia.hasNext()) {
            konsumer.accept(zamówienia.next());
        }
    }
}
