package com.example.zabawy;

public class Glowna {
    public static void main(String[] args) {
        WczytywaczZamowien wczytywaczZamowien = new WczytywaczZamowien();
        int suma = SumatorZamowien.sumujZamówienia(wczytywaczZamowien);
        System.out.println(suma);
    }
}
