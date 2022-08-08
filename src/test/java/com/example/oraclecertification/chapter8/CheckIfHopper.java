package com.example.oraclecertification.chapter8;

public class CheckIfHopper implements CheckTrait {

    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}
