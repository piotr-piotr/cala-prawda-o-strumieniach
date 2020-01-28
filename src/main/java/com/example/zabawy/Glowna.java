package com.example.zabawy;

public class Glowna {
    public static void main(String[] args) {
        WczytywaczZamowien wczytywaczZamowien = new WczytywaczZamowien();
        Zamowienie[] zamówienia = wczytywaczZamowien.wczytajZamówienia();
        int suma = SumatorZamowien.sumujZamówienia(zamówienia);
        System.out.println(suma);
    }
}
