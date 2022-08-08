package com.example.oraclecertification.chapter4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.springframework.util.Assert.isTrue;

public class StringBuilderSandBox {
    @Test
    public void test1() {
        StringBuilder a = new StringBuilder("abc");
        a.append("de");
        StringBuilder b = a;
        isTrue(a.equals(b));
    }

    @Test
    public void test2() {
        var sb = new StringBuilder("animals");
        sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        System.out.println(sb);
    }

    @Test
    public void test3() {
        var a1 = new StringBuilder("a");
        var a2 = new StringBuilder("a");
        System.out.println(a1 == a2);
    }

    @Test
    public void test4() {
        var test1 = "String";
        var test2 = new StringBuilder(test1);
        System.out.println(test1 == test2.toString());
    }

    @Test
    public void test5() {
        var string1 = "Hello World";
        var string2 = new String("Hello World").intern();
        System.out.println(string1 == string2);
    }

    @Test
    public void test6() {
        int[] array1 = {1};
        int[] array2 = {1};
        System.out.println(Arrays.equals(array1,array2));
    }
}
