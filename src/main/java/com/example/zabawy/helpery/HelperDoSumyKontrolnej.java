package com.example.zabawy.helpery;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HelperDoSumyKontrolnej {
    public static String policzSumęKontrolną(int liczba) {
        byte[] wynik = String.format("%d", liczba).getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            for (int i = 0; i < 100000; i++) {
                wynik = md.digest(wynik);
            }
            return byteArrayToHex(wynik).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            return "???";
        }
    }

    // https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
