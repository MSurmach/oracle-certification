package com.example.oraclecertification.chapter4;

import org.junit.jupiter.api.Test;

import java.time.*;

public class DateAndTimeSandBox {
    @Test
    public void test1() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDate.of(1994, Month.AUGUST,17));
        System.out.println(LocalTime.of(16,40, 25));
    }
}
