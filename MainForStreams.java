package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainForStreams {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Andrew", "Brandon", "Michael");
        names.count();
        names.findFirst().get();
        List<String> collect = names.collect(Collectors.toList());
        Set<String> collect1 = names.collect(Collectors.toSet());

        Ship ship1 = new Ship("ship1");
        Ship ship2 = new Ship("Ship2");
        Ship ship3 = new Ship("Ship3");

        Stream.of(ship1, ship2, ship3)
                .filter(ship -> ship.getColor().equals("White"))
                .filter(ship -> ship.getEngineType() != "Electric"); //BETTER WAY

        Stream.of(ship1, ship2, ship3)
                .filter(ship -> ship.getColor().equals("White") && ship.getEngineType() != "Electric"); //ALSO ACCEPTABLE

        String s = Stream.of("John", "Mary", "Jack", "Stacey")
                .filter(string -> string.equals("Mary"))
                .findFirst().get(); //Mary

        List<String> names2 = Arrays.asList("Andrew", "Brandon", "Michael");
        List<Integer> namesLengths = names2.stream()
                .map(string -> string.length())
                .collect(Collectors.toList());

        List<String> namesLengthsSigned = names2.stream()
                .map(str -> sign(str, SIGNATURE))
                .collect(Collectors.toList());

        List<String> name = Arrays.asList("Andrew", "Brandon", "Michael");
        OptionalDouble averageNameLengthOptional = name.stream()
                .mapToInt(String::length)
                .average();
        averageNameLengthOptional.ifPresent(System.out::println);

        //VS

        List<Double> numbers = Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0);
        double sum = numbers.stream()
                .reduce(0.0, (a, b) -> a + b);
        double average = sum / numbers.size();
        System.out.println("Average: " + average);


    }
private static final String SIGNATURE = "0xcccdebvff0a";
    private static String sign(String name, String signature) {
        return name + signature;
    }
}
