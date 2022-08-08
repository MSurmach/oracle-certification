package com.example.oraclecertification.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public void chew(List<Double> input) {
    }

    public void chew(ArrayList<Object> input) {
    }

    public static void main(String[] args) {
        /*List<? super IOException> exceptions = new ArrayList<Exception>();
        exceptions.add(new IOException());
        exceptions.add(new Exception());
        exceptions.add(new Object());*/
        List<? extends Number> list = new ArrayList<Integer>();

    }
}
