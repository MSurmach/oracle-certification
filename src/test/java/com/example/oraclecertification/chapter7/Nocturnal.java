package com.example.oraclecertification.chapter7;

public interface Nocturnal {
    int number = 10;

    void someMethod();

    static void someStaticMethod(){

    }
    default void printNumber() {
        System.out.println(number);
    }
}
