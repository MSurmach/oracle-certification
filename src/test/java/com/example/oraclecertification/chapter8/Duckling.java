package com.example.oraclecertification.chapter8;

public class Duckling {
    public static void makeSound(String sound) {
        LearnToSpeak learner = System.out::println;
        DuckHelper.teacher(sound, learner);
    }
}
