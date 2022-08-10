package com.example.oraclecertification;

import java.util.concurrent.Executors;

public class DeadlockExample {
    static class Food {
    }

    static class Water {
    }

    record Fox(String name) {
        public void eatAndDrink(Food food, Water water) {
            synchronized (food) {
                System.out.println(name() + " Got Food!");
                move();
                synchronized (water) {
                    System.out.println(name() + " Got Water!");
                }
            }
        }

        public void drinkAndEat(Food food, Water water) {
            synchronized (water) {
                System.out.println(name() + " Got Food!");
                move();
                synchronized (food) {
                    System.out.println(name() + " Got Water!");
                }
            }
        }

        public void move() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) {
            var foxy = new Fox("Foxy");
            var tails = new Fox("Tails");
            var food = new Food();
            var water = new Water();
            var service = Executors.newScheduledThreadPool(10);
            try {
                service.submit(() -> foxy.eatAndDrink(food, water));
                service.submit(() -> tails.drinkAndEat(food, water));
            } finally {
                service.shutdown();
            }
        }
    }
}
