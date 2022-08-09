package com.example.oraclecertification;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTraining {
    public static void printHello(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("Hello");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        new Thread(() -> printHello(lock)).start();
        Thread.sleep(998);
        if (lock.tryLock()){
            try {
                System.out.println("Lock obtained, entering protected code");
            }
            finally {
                lock.unlock();
            }
        }
        else System.out.println("Unable to acquire lock, doing something else");
    }
}
