package com.example.zabawy;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Glowna {
    public static void main(String[] args) {
        Spliterator<Zamowienie> wczytywaczZamowien = new WczytywaczZamowien();
        Stream<Zamowienie> strumieńZamówień = StreamSupport.stream(wczytywaczZamowien, true);
//        strumieńZamówień = strumieńZamówień.sequential();
//        strumieńZamówień = strumieńZamówień.parallel();
        strumieńZamówień.forEach(z -> System.out.println(z + ", wątek=" + Thread.currentThread().getId()));
    }
}
