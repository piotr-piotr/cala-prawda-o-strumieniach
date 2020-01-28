package com.example.zabawy;

import com.example.zabawy.helpery.HelperDoSumyKontrolnej;

import java.util.concurrent.RecursiveAction;

public class MojaAkcja extends RecursiveAction {
    private final int odIlu;
    private final int doIlu;

    public MojaAkcja(int odIlu, int doIlu) {
        this.odIlu = odIlu;
        this.doIlu = doIlu;
    }

    @Override
    protected void compute() {
        System.out.println("zaczynam - " + odIlu + " - " + doIlu + " (" + Thread.currentThread().getId() + ")");
        for (int i = odIlu; i < doIlu; i++) {
            System.out.println(i + " - " + HelperDoSumyKontrolnej.policzSumęKontrolną(i) + " - " + Thread.currentThread().getId());
        }
    }
}
