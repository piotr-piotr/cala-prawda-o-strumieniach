package com.example.zabawy;

import java.util.Spliterator;

public class Glowna {
    public static void main(String[] args) {
        Spliterator<Zamowienie> wczytywaczZamowien = new WczytywaczZamowien();
        System.out.println(UsredniaczZamowienRownolegly.policzŚrednią(wczytywaczZamowien));
    }
}
