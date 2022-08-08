package com.example.oraclecertification.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringsSandBox {

    @Test
    public void textBlock() {
        String name = """
                Fluffy""";
        System.out.println(name);
    }

    @Test
    public void getLength() {
        var name = "Fluffy";
        var expectedLength = 6;
        assertTrue(name.length() == expectedLength);
    }

    @Test
    public void getSingleChar() {
        var name = "animals";
        var expectedCharAtPosition2 = 'i';
        assertEquals(name.charAt(2), expectedCharAtPosition2);
        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            name.charAt(7);
        });
        String expectedMessage = "String index out of range: 7";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    public void partOfString() {
        var name = "animals";
        System.out.println(name.substring(5, name.length()));
    }

    @Test
    public void test1() {
        var block = """
                This is
                a text block""";
        block = block.indent(3);
        System.out.println(block);
    }

    @Test
    public void test2() {
        var block = """
                a
                 b
                c""";
        var concat = " a\n" + "  b\n" + " c";
        System.out.println(block.length());
        System.out.println(block.indent(1).length());
        System.out.println("-------");
        System.out.println(block.indent(1));
        System.out.println(concat.indent(-1));
        System.out.println(concat.indent(-4));
        System.out.println(concat.stripIndent());
    }

    @Test
    public void translateEscape() {
        var str = "1\\\"2";
        System.out.println(str);
        System.out.println(str.translateEscapes());
    }

    @Test
    public void formatString() {
        var name = "Kate";
        var orderId = 5;
        System.out.println(String.format("Hello %s, order %d is ready", name, orderId));
        System.out.println("Hello %s, order %d is ready".formatted(name, orderId));
    }

    @Test
    public void formatString2() {
        var number = String.format("%.1f", 90.25);
        System.out.println(number);
    }

    @Test
    public void piNumber() {
        var pi = 3.14159265359;
        System.out.format("%f\n", pi);
        System.out.format("%12.8f\n", pi);
        System.out.format("%012f\n", pi);
        System.out.format("%12.2f\n", pi);
        System.out.format("%.3f\n", pi);
    }

    @Test
    public void methodChaining() {
        var start = "AniMaL   ";
        String trimmed = start.trim();
        System.out.println("Trimmed: [%s]".formatted(trimmed));
        var lowercase = trimmed.toLowerCase();
        System.out.println("In lowercase: [%s]".formatted(lowercase));
        var result = lowercase.replace('a', 'A');
        System.out.println("Result is: " + result);
        var result2 = start.trim().toLowerCase().replace('a', 'A');
        System.out.println("Result2 is: " + result2);
    }

    @Test
    public void sand() {
        String s1 = """
                purr""";
        System.out.println(s1 += "two");
        System.out.println(s1.length());
    }

    @Test
    public void testAutoboxing() {
        int numberAsInt = 9;
        Integer numberAsInteger = 10;
        long l = 9;
        //numberAsInt = numberAsInteger;
        //System.out.println(numberAsInt);
        numberAsInteger = numberAsInt;
        System.out.println(numberAsInteger);
    }

}
