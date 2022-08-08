package com.example.oraclecertification.chapter10;

import java.util.ArrayList;
import java.util.Collections;

public record Duck(int id) {

    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        for (int i = 0; i < 10; i++) {
            ducks.add(new Duck(i));
        }
        Collections.shuffle(ducks);
        System.out.println("Before sorting:");
        System.out.println(ducks);
        Collections.sort(ducks, (o1, o2) -> o1.id - o2.id);
        Collections.reverse(ducks);
        System.out.println("After sorting:");
        System.out.println(ducks);
    }
}
