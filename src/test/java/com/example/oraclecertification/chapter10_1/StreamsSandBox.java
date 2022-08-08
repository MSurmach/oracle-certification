package com.example.oraclecertification.chapter10_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsSandBox {
    public static void main(String[] args) {
//        Stream<Integer> integerStream = Stream.iterate(1, value -> value < 20, value -> value + 2);
//        integerStream.limit(20).forEach(System.out::println);
//        integerStream.forEach(System.out::print);
//        System.out.println(integerStream);
//        Stream<Double> infinite = Stream.generate(Math::random);
//        infinite.forEach(System.out::println);
        Stream<String> stream = Stream.of("w", "o", "l", "f");
//        Optional<String> reduced = stream.reduce((value1, value2) -> value1 + value2);
//        System.out.println(reduced.get());

        List<String> zero = List.of();
        List<String> one = List.of("Bonobo");
        List<String> two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("----");
        var stream1 = Stream.of("black bear", "brown bear", "grizzly", "g");
        long count = stream1.peek(s -> System.out.println("before filtering: " + s)).filter(value -> value.startsWith("b")).peek(System.out::println).count();
        System.out.println(count);

        var numbers = new ArrayList<>();
        var letters = new ArrayList<>();
        numbers.add(1);
        numbers.add('a');

        Stream<List<?>> stream2 = Stream.of(numbers, letters);
        stream2.map(List::size).forEach(System.out::print);

        System.out.println();

        Optional<String> name = Optional.of("Maxim");
        Optional<Integer> countLetters = name.map(String::length);
        countLetters.ifPresent(System.out::println);


        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println("Result is: " + result);


    }
}
