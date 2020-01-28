package com.example.zabawy;

import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumatorZamowienRownolegly extends RecursiveTask<Integer> {
    private final Spliterator<Zamowienie> zamówienia;

    public SumatorZamowienRownolegly(Spliterator<Zamowienie> zamówienia) {
        this.zamówienia = zamówienia;
    }

    @Override
    protected Integer compute() {
        if (zamówienia.estimateSize() <= 20) {
            System.out.println("zaczynam, size=" + zamówienia.estimateSize() + ", wątek=" + Thread.currentThread().getId());
            int[] suma = {0}; // musi być efektywnie finalne ale i mutowalne
            while (zamówienia.tryAdvance(z -> suma[0] += z.getCena() * z.getIleSztuk()));
            return suma[0];
        } else {
            System.out.println("dzielę, mój size=" + zamówienia.estimateSize() + ", wątek=" + Thread.currentThread().getId());
            Spliterator<Zamowienie> drugaCzęść = zamówienia.trySplit();
            if (drugaCzęść == null) {
                throw new RuntimeException("to się nie ma prawa zdarzyć");
            }
            Spliterator<Zamowienie> pierwszaCzęść = zamówienia;
            SumatorZamowienRownolegly podakcja1 = new SumatorZamowienRownolegly(pierwszaCzęść);
            SumatorZamowienRownolegly podakcja2 = new SumatorZamowienRownolegly(drugaCzęść);
            ForkJoinPool.commonPool().execute(podakcja1);
            ForkJoinPool.commonPool().execute(podakcja2);
            int suma1 = podakcja1.join();
            int suma2 = podakcja2.join();
            return suma1 + suma2;
        }
    }
}
