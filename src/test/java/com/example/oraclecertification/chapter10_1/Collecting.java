package com.example.oraclecertification.chapter10_1;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collecting {

    @Test
    public void test1() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);
    }

    @Test
    public void test2() {
        double asDouble = IntStream.rangeClosed(0, 2).peek(System.out::println).average().getAsDouble();
    }

    @Test
    public void test3() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result);
    }

    @Test
    public void test4() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result = ohMy.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result);
    }

    @Test
    public void test5() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }

    @Test
    public void test6() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(
                Collectors.toMap(String::length, Function.identity(), (val1, val2) -> val1 + ", " + val2));
        System.out.println(map);
        System.out.println(map.getClass());
    }

    @Test
    public void test7() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(
                Collectors.toMap(String::length, Function.identity(), (val1, val2) -> val1 + ", " + val2, TreeMap::new));
        System.out.println(map);
        System.out.println(map.getClass());
    }

    @Test
    public void test8() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> collected = ohMy.collect(Collectors.groupingBy(String::length));
        System.out.println(collected);
    }

    @Test
    public void test9() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> collected = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(collected);
    }

    @Test
    public void test10() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> partitioned = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(partitioned);
    }

    @Test
    public void test11() {
        var ohMy = Stream.of("lions", "tigers", "lions", "bears");
        Map<Boolean, Set<String>> partitioned = ohMy.collect(
                Collectors.partitioningBy(
                        s -> s.length() <= 5,
                        Collectors.toSet()));
        System.out.println(partitioned);
    }

    @Test
    public void test12() {
        var ohMy = Stream.of("lions", "tigers", "lions", "bears");
        Map<Integer, Long> collected = ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collected);
    }

    @Test
    public void test13() {
        var ohMy = Stream.of("lions", "tigers", "lions", "bears");
        Map<Integer, Optional<Character>> collect = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy((o1, o2) -> o1 - o2)
                        )
                )
        );
        System.out.println(collect);
    }

    @Test
    public void test14() {
        var spliterator = Stream.generate(() -> "x")
                .spliterator();

        spliterator.tryAdvance(System.out::print);
        var split = spliterator.trySplit();
        split.tryAdvance(System.out::print);
    }
}
