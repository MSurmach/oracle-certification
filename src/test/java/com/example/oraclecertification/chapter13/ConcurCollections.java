package com.example.oraclecertification.chapter13;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurCollections {

    @Test
    public void test1() {
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for (var n : favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(n + 1);
        }
        System.out.println();
        for (var n : favNumbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Size: " + favNumbers.size());

    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }
}
