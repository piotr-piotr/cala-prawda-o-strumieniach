package com.example.zabawy.helpery;

import com.example.zabawy.Zamowienie;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class KolektorUsredniajacyZamowienia implements Collector<Zamowienie, Integer[], Double> {
    @Override
    public Supplier<Integer[]> supplier() {
        return () -> new Integer[] {0, 0};
    }

    @Override
    public BiConsumer<Integer[], Zamowienie> accumulator() {
        return (pamięć, zamówienie) -> {
            pamięć[0] += (zamówienie.getCena() * zamówienie.getIleSztuk());
            pamięć[1]++;
        };
    }

    @Override
    public BinaryOperator<Integer[]> combiner() {
        return new BinaryOperator<Integer[]>() {
            @Override
            public Integer[] apply(Integer[] pamięć1, Integer[] pamięć2) {
                return new Integer[] {pamięć1[0] + pamięć2[0], pamięć1[1] + pamięć2[1]};
            }
        };
    }

    @Override
    public Function<Integer[], Double> finisher() {
        return pamięć -> pamięć[0].doubleValue() / pamięć[1];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.UNORDERED);
    }
}
