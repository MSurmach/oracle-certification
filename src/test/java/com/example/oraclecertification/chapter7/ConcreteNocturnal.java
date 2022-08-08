package com.example.oraclecertification.chapter7;

public class ConcreteNocturnal {
    public class Movie {
        private int butter = 5;

        private Movie() {
        }

        protected class Popcorn {
            private Popcorn() {
            }

            public static int butter = 10;

            public void startMovie() {
                System.out.println(Movie.this.butter);
            }
        }
    }

    public static void main(String[] args) {
        ConcreteNocturnal.Movie.Popcorn in = new ConcreteNocturnal().new Movie().new Popcorn();
        in.startMovie();
    }
}
