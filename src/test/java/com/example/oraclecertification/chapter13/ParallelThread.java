package com.example.oraclecertification.chapter13;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ParallelThread {

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5).stream().map(value -> doWork(value)).forEach(System.out::println);
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5).stream().parallel().map(value -> doWork(value)).forEachOrdered(System.out::println);
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    @Test
    public void test3() {

    }

    private static int doWork(int input) {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
        }
        return input;
    }
}
