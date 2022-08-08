package com.example.oraclecertification.chapter9;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

public class CollectionDemo {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);
        boolean removingResult = list.removeIf(s -> s.startsWith("M"));
        System.out.println(removingResult);
        System.out.println(list);
    }

    @Test
    public void test2() {
        var heights = new ArrayList<Integer>(10);
        //heights.add(1, 4);
        int h = heights.get(0);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[0]);
        System.out.println(objectArray.length);
        System.out.println(stringArray.length);
    }

    @Test
    public void test4() {
        Set<Character> letters = Set.of('z', 'o');
        Set<Character> copy = Set.copyOf(letters);
        System.out.println(letters);
        System.out.println(copy);
    }

    @Test
    public void test5() {
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
        Map<String, String> entries = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")
        );
    }

    @Test
    public void test6() {
        Map<Integer, String> map = Map.of(1, "a", 2, "b", 3, "c");
        map.forEach((i, s) -> System.out.println(i + " " + s));
        map.values().forEach(System.out::println);
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    @Test
    public void test7() {
        // BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        BiFunction<String, String, String> mapper = (v1, v2) -> null;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Sam", null);

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        //String tom = favorites.merge("Tom", "Skyride", mapper);
        String sam = favorites.merge("Sam", "Skyride", mapper);

        System.out.println(favorites);
        System.out.println(jenny);
        //System.out.println(tom);
        System.out.println(sam);
    }
}
