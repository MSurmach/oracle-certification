package com.example.oraclecertification.chapter11;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class ExceptionsSandbox {

    private void methodThatCantThrowException() {
        System.out.println("Can't throw an exception");
    }

    private void methodThatThrowIllegalArgumentException(int number) {
        if (number < 0) throw new IllegalArgumentException();
    }

    @Test
    public void test1() {
        try {
            methodThatCantThrowException();
        } catch (RuntimeException exception) {
            System.out.println("unchecked exceptions can be reached");
        }
    }

    @Test
    public void test2() {
        try {
            methodThatCantThrowException();
        } catch (Exception exception) {
            System.out.println("Exception class is a father of unchecked exceptions, therefore can be reached");
        }
    }

    @Test
    public void test3() {
        try {
            //this method never thrown a checked exception
            methodThatCantThrowException();
        }
//         This part doesn't compile, because this checked exception can not be reached
//        catch (IOException exception){
//
//        }
        catch (Exception exception) {
            System.out.println("Exception class is a father of unchecked exceptions, therefore can be reached");
        }
    }

    @Test
    public void test4() {
        String type = "Something";
        Object object = type;
        try {
            Integer number = (Integer) object;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void test5() {
        methodThatThrowIllegalArgumentException(-1);
    }

    @Test
    public void test6() {
        int number = Integer.parseInt("abc");
    }

    @Test
    public void test7() {
        double d = 6001234.567;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(d));
        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d));
        NumberFormat f3 = new DecimalFormat("Your Balance is: $#,###,###.##");
        System.out.println(f3.format(d));
    }

    @Test
    public void test8() {
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());
        System.out.println(date.getDayOfYear());
    }

    @Test
    public void test9() {
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dt = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Test
    public void test10() {
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dt = LocalDateTime.of(date, time);
        var f = DateTimeFormatter.ofPattern("MMMM dd,yyyy 'at' hh:mm");
        System.out.println(dt.format(f));
    }

    @Test
    public void test11() {
        var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        var dtNow = LocalDateTime.now();
        var f1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        var f2 = DateTimeFormatter.ofPattern(" hh:mm");
        System.out.println(dt.format(f1) + " at" + dt.format(f2));
        var f3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(f3.format(dt));
        System.out.println(dtNow.format(f3));
    }

    @Test
    public void test12() {
        String pattern = "#,###.0";
        String message = DoubleStream.of(5.21, 8.49, 1234).mapToObj(value -> new DecimalFormat(pattern).format(value)).collect(Collectors.joining("> <"));
        System.out.println("<" + message + ">");
    }

    @Test
    public void test13() {
        hop(null, 1);
    }

    private static void hop(String name, Integer jump) {
        System.out.println(name.toLowerCase() + " " + jump);
    }
}
