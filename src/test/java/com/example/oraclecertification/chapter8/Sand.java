package com.example.oraclecertification.chapter8;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Sand {

    @Test
    public void mainAnalogue() {
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());

        Consumer<String> c1 = x -> System.out.print("1: " + x);
        Consumer<String> c2 = x -> System.out.println(", 2: " + x);

        Consumer<String> combined = c1.andThen(c2);
        combined.accept("Annie");

        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;
        Function<Integer, Integer> combinedFunc = after.compose(before);
        System.out.println(combinedFunc.apply(3));

        BooleanSupplier b1 = () -> true;
        DoubleSupplier d1;
        IntSupplier i1;
        LongSupplier l1;
        DoubleToIntFunction dti;

        var d = 1.0;
        ToIntFunction<Double> doubleToIntFunction = value -> 1;
        int result = doubleToIntFunction.applyAsInt(d);
        System.out.println(result);
        List<Integer> list = new ArrayList<>();
        list.sort((o1, o2) -> o1.compareTo(o2));
    }

    @Test
    public void test2() {
        var date = LocalDate.of(2022, Month.APRIL, 30);
        date = date.plusDays(2);
        date = date.plusYears(3);
        System.out.println(date.getYear() + " " + date.getMonth()
                + " " + date.getDayOfMonth());
    }
}
