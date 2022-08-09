package com.example.oraclecertification;

import java.util.Objects;
import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;

    /*public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000_000; i++) {
                counter++;
            }
        }).start();
        while (counter < 1_000_000) System.out.println("Not reached yet");
        System.out.println("Reached: " + counter);
    }*/
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
            });
            Object res = result.get(10, TimeUnit.SECONDS);
            System.out.println(Objects.isNull(res));
            System.out.println("Reached");
        }
        catch (TimeoutException exception){
            System.out.println("Not reached in time");
        }
        finally {
            executorService.shutdown();
        }
    }
}
