package com.example.zabawy;

public class SumatorZamowien {
    public static int sumujZamówienia(Zamowienie[] zamówienia) {
        int suma = 0;
        for (Zamowienie zamówienie : zamówienia) {
            suma += zamówienie.getCena() * zamówienie.getIleSztuk();
        }
        return suma;
    }
}
