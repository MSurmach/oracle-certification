package com.example.oraclecertification;

public class Zoo {
    public static void pause() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread finished");
    }

    public static void main(String[] args) {
        var job = new Thread(() -> pause());
        job.setDaemon(true);
        job.start();
        System.out.println(job.getState());
        System.out.println("Main thread finished");
    }
}
