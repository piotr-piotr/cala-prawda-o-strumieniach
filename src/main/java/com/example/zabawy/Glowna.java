package com.example.zabawy;

import java.util.Iterator;
import java.util.function.Consumer;

public class Glowna {
    public static void main(String[] args) {
        WczytywaczZamowien wczytywaczZamowien = new WczytywaczZamowien();
        int suma = new SumatorZamowienRownolegly(wczytywaczZamowien).invoke();
        System.out.println(suma);
    }

    private static void forEach(Iterator<Zamowienie> zamówienia, Consumer<Zamowienie> konsumer) {
        while (zamówienia.hasNext()) {
            konsumer.accept(zamówienia.next());
        }
    }
}
