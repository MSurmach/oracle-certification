package com.example.oraclecertification.chapter8;

public class SpringStartDemo {
    public static void main(String[] args) {
        var str = "Zoo";
        StringStart lambda = prefix -> str.startsWith(prefix);
        StringStart methodRef = str::startsWith;
        System.out.println(methodRef.beginningCheck("Z"));
    }
}
