package com.example.oraclecertification.chapter10_1;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class ExceptionCaseStudy {
    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public void good() throws IOException {
        ExceptionCaseStudy.create().stream().count();
    }

    public static void main(String[] args) throws IOException {
        new ExceptionCaseStudy().good();
    }

    public void bad() throws IOException {
        Supplier<List<String>> supplier = () -> {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException exception) {
                throw new RuntimeException();
            }
        };
    }
}
