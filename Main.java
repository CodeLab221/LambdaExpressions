package org.example;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        Integer age = 3;

        Predicate<String> startsWithABCTest = s -> s.startsWith("ABC");

        String toTest = "";
        if (toTest.startsWith("ABC")) {
            System.out.println("The old way");
        }

        System.out.println(startsWithABCTest.test("ABCDEF"));
        System.out.println(startsWithABCTest.test("CBEFGG"));

        Function<String, Integer> stringLengthFunction = string -> {
                return string.length();
        };

        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt();
        Integer integer = randomNumberSupplier.get();
        Consumer<Integer> numberConsumer = (num) -> System.out.println(num);
        numberConsumer.accept(integer);


        System.out.println(stringLengthFunction.apply("ABCDE"));

        Function<String, Ship> stringToShip = string -> {
            return new Ship(string);
        };

        Function<Ship, Ship> paintFunction = s -> {
            s.setColor("Orange");
            return s;
        };

        Function<Ship, Ship> engineUpgrade = ship -> {
            ship.setEngineType("ELECTRIC");
            return ship;
        };

        Function<Ship, Ship> renameShip = ship -> {
            ship.setName("Renamed");
            return ship;
        };

        BiFunction<Ship, Ship, Ship> bif = (s1, s2) -> {
            return new Ship("name");
        };

        Ship originalShip = new Ship("Original Name");
        originalShip.setColor("White");

        Ship orangeship = paintFunction.apply(new Ship("orangeship"));

        Stream<Function<Ship, Ship>> functionStream =
                Stream.of(originalShip)
                        .map(ship -> {
                            return new Ship("Totally new ship");
                        })
                        .map(ship -> paintFunction)
                        .map(ship -> engineUpgrade);

        Ship winners = stringToShip.apply("Winners");

        List<Ship> shipsList = Stream.of(orangeship, new Ship("blueship"), new Ship("Whiteship"))
                .map(sh -> {
                    sh.setColor("Orange");
                    return sh;
                }) //we paint
                .map(engineUpgrade) //we upgrade, we provide a Function<Ship, Ship>
                .collect(Collectors.toList());

        Stream<Ship> stream = shipsList.stream();
        Set<String> stringSet = Set.of("a","b","c");
        Stream<String> stream1 = stringSet.stream();


    }

    private static int measureString(String string) {
        return string.length();
    }
}