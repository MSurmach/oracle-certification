package com.example.oraclecertification.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(name.charAt(2) == expectedCharAtPosition2);
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
}
