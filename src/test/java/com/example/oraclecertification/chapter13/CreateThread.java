package com.example.oraclecertification.chapter13;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        service.awaitTermination(1, TimeUnit.MINUTES);
        if (service.isTerminated()) System.out.println("Finished");
        else System.out.println("At least one task is still running");
    }

    @Test
    public void test5() throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<?> future = service.submit(() -> System.out.println("Hello"));
        Thread.sleep(500);
        System.out.println(future.cancel(true));
        System.out.println(future.isDone());
    }

    @Test
    public void test6() throws Exception {
        var service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> future = service.submit(() -> 30 + 11);
            System.out.println(future.get());
        } finally {
            service.shutdown();
        }
    }

    @Test
    public void test7() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> r1 = service.scheduleAtFixedRate(task1, 10, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(task2, 20, TimeUnit.SECONDS);
        Thread.sleep(30000);
        System.out.println(r2.get());
    }

    @Test
    public void test8() {
        Lock lock = new ReentrantLock();
        if (lock.tryLock()) {
            try {
                lock.lock();
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        }
        new Thread(()-> System.out.println(lock.tryLock())).start();
    }
}
