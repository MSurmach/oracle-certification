package com.example.oraclecertification.chapter8;

public class StringTwoParameterCheckerDemo {
    public static void main(String[] args) {
        StringTwoParameterChecker methodRef = String::startsWith;
        StringTwoParameterChecker lambda = (s, p) -> s.startsWith(p);
        System.out.println(methodRef.check("Zoo", "A"));
    }
}
