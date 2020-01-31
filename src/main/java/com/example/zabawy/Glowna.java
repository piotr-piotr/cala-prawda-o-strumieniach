package com.example.zabawy;

import com.example.zabawy.helpery.KolektorUsredniajacyZamowienia;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Glowna {
    public static void main(String[] args) {
        Stream<Zamowienie> strumienZamowien = StreamSupport.stream(new WczytywaczZamowien(), true);
        Double średnia = strumienZamowien.collect(new KolektorUsredniajacyZamowienia());
        System.out.println("średnia = " + średnia);
    }
}
