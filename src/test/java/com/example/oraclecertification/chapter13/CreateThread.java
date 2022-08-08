package com.example.oraclecertification.chapter13;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThread {
    @Test
    public void test1() {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };
        System.out.println("begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printInventory).start();
        System.out.println("end");
    }

    @Test
    public void test2() {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };
        System.out.println("begin");
        new Thread(printInventory).run();
        new Thread(printRecords).run();
        new Thread(printInventory).run();
        System.out.println("end");
    }

    @Test
    public void test3() {
        var job = new Thread(() -> pause());
//        job.setDaemon(true);
        job.start();
        System.out.println("Main method finished");
    }

    private static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread finished");
    }

    @Test
    public void test4() throws InterruptedException {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
        } finally {
            service.shutdown();
        }
        System.out.println("end");
    }
}
