package com.example.oraclecertification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {
    private static int counter = 0;

    private static void incrementAndReport() {
        synchronized (SheepManager.class) {
            System.out.print(++counter + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(SheepManager::incrementAndReport);
            }
        } finally {
            service.shutdown();
        }
    }
}
