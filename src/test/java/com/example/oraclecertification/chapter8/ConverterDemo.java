package com.example.oraclecertification.chapter8;

public class ConverterDemo {
    public static void main(String[] args) {
        Converter converter = Math::round;
        System.out.println(converter.round(1.3));
    }
}
