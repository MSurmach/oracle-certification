package com.example.oraclecertification.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T, S> ShippableAbstractCrate<T, S> ship(T t) {
        System.out.println("Shipping " + t);
        return new ShippableAbstractCrate<T, S>();

    }
}

class HandlerDemo {
    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<>();
//        birds.add(new Bird());
//        birds.add(new Sparrow());
//        System.out.println(birds);

    }
}

class Sparrow extends Bird {
}

class Bird {
}