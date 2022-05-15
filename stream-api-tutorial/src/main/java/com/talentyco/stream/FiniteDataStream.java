package com.talentyco.stream;

import java.util.stream.Stream;

public class FiniteDataStream {
    public static void main(String[] args) {

        // Finite Data
        System.out.println("\n\n\nStream Finite Data: ");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

    }
}
