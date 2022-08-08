package com.example.oraclecertification.chapter11;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class LocaleSandBox {

    @Test
    public void test1() {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }

    @Test
    public void test2() {
        System.out.println(Locale.getDefault());
        Locale l1 = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        Locale.setDefault(l1);
        System.out.println(Locale.getDefault());
    }

    @Test
    public void test3() {
        System.out.println(Locale.getDefault());
    }

    @Test
    public void test4() {
        double price = 48;
        var myLocale = NumberFormat.getCurrencyInstance();
        System.out.println(myLocale.format(price));
    }

    @Test
    public void test5() {
        double successRate = 0.802;
        var us = NumberFormat.getPercentInstance(Locale.US);
        var gr = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(us.format(successRate));
        System.out.println(gr.format(successRate));
    }

    @Test
    public void test6() {
        var formatters = Stream.of(
                NumberFormat.getCompactNumberInstance(),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG),

                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG),
                NumberFormat.getNumberInstance()
        );
        formatters.map(value -> value.format(3490000000L)).forEach(System.out::println);
    }

    @Test
    public void test7() {
        var us = new Locale("en", "US");
        var france = new Locale("fr", "FR");
        printWelcomeMessage(us);
        printWelcomeMessage(france);
    }

    @Test
    public void test8() {
        var us = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", us);
        resourceBundle.keySet().stream().map(s -> s + ": " + resourceBundle.getString(s)).forEach(System.out::println);
    }

    @Test
    public void test9() {
        var props = new Properties();
        props.setProperty("name", "Our zoo");
        props.setProperty("open", "10am");
        System.out.println(props.getProperty("camel"));
        System.out.println(props.getProperty("camel","Bob"));
        System.out.println(props.get("open"));
    }

    private static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        String hello = rb.getString("hello");
        String open = rb.getString("open");
        System.out.println(hello + ", " + MessageFormat.format(open, "Maksim"));
    }

}