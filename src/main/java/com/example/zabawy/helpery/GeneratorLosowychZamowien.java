package com.example.zabawy.helpery;

import com.example.zabawy.Zamowienie;
import java.util.Random;

public class GeneratorLosowychZamowien {
    private static final Random generator = new Random(0);
    
    public static Zamowienie dajLosoweZamówienie() {
        int id = generator.nextInt(10000);
        int cena = 1 + generator.nextInt(100);
        int sztuk = 1 + generator.nextInt(20);
        return new Zamowienie(id, cena, sztuk);
    }
}
