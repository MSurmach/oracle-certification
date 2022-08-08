package com.example.oraclecertification.chapter10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Search {
    @Test
    public void test1() {
        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        var index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);
    }
}
