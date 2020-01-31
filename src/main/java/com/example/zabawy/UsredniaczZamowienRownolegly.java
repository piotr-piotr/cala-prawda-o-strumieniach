package com.example.zabawy;

import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class UsredniaczZamowienRownolegly extends RecursiveTask<Integer[]> {
    private final Spliterator<Zamowienie> zamówienia;

    public UsredniaczZamowienRownolegly(Spliterator<Zamowienie> zamówienia) {
        this.zamówienia = zamówienia;
    }

    @Override
    protected Integer[] compute() {
        if (zamówienia.estimateSize() <= 20) {
            System.out.println("zaczynam, size=" + zamówienia.estimateSize() + ", wątek=" + Thread.currentThread().getId());
            Integer[] sumaIIlość = {0, 0};
            while (zamówienia.tryAdvance(z -> {
                sumaIIlość[0] += z.getCena() * z.getIleSztuk();
                sumaIIlość[1]++;
            }));
            return sumaIIlość;
        } else {
            System.out.println("dzielę, mój size=" + zamówienia.estimateSize() + ", wątek=" + Thread.currentThread().getId());
            Spliterator<Zamowienie> drugaCzęść = zamówienia.trySplit();
            if (drugaCzęść == null) {
                throw new RuntimeException("to się nie ma prawa zdarzyć");
            }
            Spliterator<Zamowienie> pierwszaCzęść = zamówienia;
            UsredniaczZamowienRownolegly podakcja1 = new UsredniaczZamowienRownolegly(pierwszaCzęść);
            UsredniaczZamowienRownolegly podakcja2 = new UsredniaczZamowienRownolegly(drugaCzęść);
            ForkJoinPool.commonPool().execute(podakcja1);
            ForkJoinPool.commonPool().execute(podakcja2);
            Integer[] sumaIIlość1 = podakcja1.join();
            Integer[] sumaIIlość2 = podakcja2.join();
            return new Integer[] {sumaIIlość1[0] + sumaIIlość2[0], sumaIIlość1[1] + sumaIIlość2[1]};
        }
    }

    public static double policzŚrednią(Spliterator<Zamowienie> zamowienia) {
        Integer[] sumaIIlość = ForkJoinPool.commonPool().invoke(new UsredniaczZamowienRownolegly(zamowienia));
        return sumaIIlość[0].doubleValue() / sumaIIlość[1];
    }


}
