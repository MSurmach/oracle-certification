package com.example.oraclecertification.chapter7.enums;

public class EnumTest {
    public static void main(String[] args) {
        /*var season = Season.SUMMER;
        System.out.println(season);*/
        for (var season :
                Season.values()) {
            System.out.println(season + " " + season.ordinal());
        }
    }
}
