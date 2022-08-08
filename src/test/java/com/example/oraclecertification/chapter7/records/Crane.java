package com.example.oraclecertification.chapter7.records;

public record Crane(int numberEggs, String name) {
    public Crane {
        System.out.println("compact constructor");
    }

    public Crane(String firstName, String lastName) {
        this(0, "%s %s".formatted(firstName, lastName));
    }

    public String toString() {
        return "sggf";
    }
}

class CraneTest {
    public static void main(String[] args) {
        var crane = new Crane("Maksim", "Surmach");
        System.out.println(crane);
        System.out.println(crane.name());
        System.out.println(crane.hashCode());
    }
}
