package com.example.zabawy;

import com.example.zabawy.helpery.HelperDoSumyKontrolnej;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SumatorZamowienRownolegly extends RecursiveTask<Integer> {
    private final int odIlu;
    private final int doIlu;
    private final Zamowienie[] zamówienia;

    public SumatorZamowienRownolegly(Zamowienie[] zamówienia, int odIlu, int doIlu) {
        this.odIlu = odIlu;
        this.doIlu = doIlu;
        this.zamówienia = zamówienia;
    }

    public SumatorZamowienRownolegly(Zamowienie[] zamówienia) {
        this(zamówienia, 0, zamówienia.length);
    }

    @Override
    protected Integer compute() {
        if (doIlu - odIlu <= 20) {
            System.out.println("zaczynam - " + odIlu + " - " + doIlu + " (" + Thread.currentThread().getId() + ")");
            int suma = 0;
            for (int i = odIlu; i < doIlu; i++) {
                suma += zamówienia[i].getCena() * zamówienia[i].getIleSztuk();
            }
            return suma;
        } else {
            int środek = odIlu + (doIlu - odIlu) / 2;
            SumatorZamowienRownolegly podakcja1 = new SumatorZamowienRownolegly(zamówienia, odIlu, środek);
            SumatorZamowienRownolegly podakcja2 = new SumatorZamowienRownolegly(zamówienia, środek, doIlu);
            ForkJoinPool.commonPool().execute(podakcja1);
            ForkJoinPool.commonPool().execute(podakcja2);
            int suma1 = podakcja1.join();
            int suma2 = podakcja2.join();
            return suma1 + suma2;
        }
    }
}
