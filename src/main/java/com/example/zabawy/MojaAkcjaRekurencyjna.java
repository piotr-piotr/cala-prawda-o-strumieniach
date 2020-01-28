package com.example.zabawy;

import com.example.zabawy.helpery.HelperDoSumyKontrolnej;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MojaAkcjaRekurencyjna extends RecursiveAction {
    private final int odIlu;
    private final int doIlu;

    public MojaAkcjaRekurencyjna(int odIlu, int doIlu) {
        this.odIlu = odIlu;
        this.doIlu = doIlu;
    }

    @Override
    protected void compute() {
        if (doIlu - odIlu <= 20) {
            System.out.println("zaczynam - " + odIlu + " - " + doIlu + " (" + Thread.currentThread().getId() + ")");
            for (int i = odIlu; i < doIlu; i++) {
                System.out.println(i + " - " + HelperDoSumyKontrolnej.policzSumęKontrolną(i) + " - " + Thread.currentThread().getId());
            }
        } else {
            int środek = odIlu + (doIlu - odIlu) / 2;
            RecursiveAction podakcja1 = new MojaAkcjaRekurencyjna(odIlu, środek);
            RecursiveAction podakcja2 = new MojaAkcjaRekurencyjna(środek, doIlu);
            ForkJoinPool.commonPool().execute(podakcja1);
            ForkJoinPool.commonPool().execute(podakcja2);
            podakcja1.join();
            podakcja2.join();
        }
    }
}
