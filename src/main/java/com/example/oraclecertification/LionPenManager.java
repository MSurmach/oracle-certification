package com.example.oraclecertification;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
    private void removeLions() {
        System.out.println("Removing lions is done by " + getThreadName());
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen is done by " + getThreadName());
    }

    private void addLions() {
        System.out.println("Adding lions is done by " + getThreadName());
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeLions();
            c1.await();
            cleanPen();
            c2.await();
            addLions();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int numOfThreads = 4;
        ExecutorService service = Executors.newFixedThreadPool(numOfThreads);
        try {
            var manager = new LionPenManager();
            var c1 = new CyclicBarrier(4);
            var c2 = new CyclicBarrier(4, () -> System.out.println("***Pen Cleaned!"));
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask(c1, c2));
            }
        } finally {
            service.shutdown();
        }
    }
}
