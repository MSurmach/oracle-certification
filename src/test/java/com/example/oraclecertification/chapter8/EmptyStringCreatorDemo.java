package com.example.oraclecertification.chapter8;

import java.util.function.Consumer;

public class EmptyStringCreatorDemo {
    public static void main(String[] args) {
        EmptyStringCreator methodRef = String::new;
        EmptyStringCreator lambda = () -> new String();
        var myString = methodRef.create();
        System.out.println(myString);
    }
}
