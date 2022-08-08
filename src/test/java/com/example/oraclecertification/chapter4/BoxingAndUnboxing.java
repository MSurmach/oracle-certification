package com.example.oraclecertification.chapter4;

import org.junit.jupiter.api.Test;

public class BoxingAndUnboxing {
    @Test
    public void test1() {
        short n1 = 1;
        byte n2 = 1;
        char n3 = 1;
        int n4 = 1;
        long n5 = 1;
        n5 = n4;
        n5 = n3;
        n5 = n2;
        n5 = n1;
        double b6 = 1L;
        float n7 = 1L;
        System.out.println(b6);
        System.out.println(n7);
        b6 = n7;
    }
}
