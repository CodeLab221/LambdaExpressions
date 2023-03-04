package org.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainForPractice {
    public static void main(String[] args) {
//        Using streams, for a given lists:
//        - [„John", „Sarah", „Mark", „Tyla", „Ellisha", „Eamonn"]
//        - [1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50]
//        a) Sort the list.
//                b) Print only those names, that start with „E” letter.
//                c) Print values greater than 30 and lower than 200.
//        d) Print names uppercase.
//                e) Remove first and last letter, sort and print names.
//                f) *Sort backwards by implementing reverse Comparator and using lambda
//        expression.
        List<String> names = List.of("John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn");
        List<Integer> numbers = List.of(1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50);

        List<String> collect = names.stream()
                .sorted()
                .collect(Collectors.toList());//sorted names list

        names.stream()
                .filter(str -> str.startsWith("E"))
                .forEach(str -> System.out.println(str));
        Predicate<Integer> p = number -> number > 30;
        numbers.stream().filter(number -> number > 30).filter(number -> number <= 200 ).forEach(x -> System.out.println(x));
        numbers.stream().filter( number -> number > 30 && number <=200 ).forEach(System.out::println);

        names.stream().forEach(str -> {
            System.out.println(str.toUpperCase());
        });

     //   names.stream().sorted(Comparator.comparing(Comparator.comparing(String::toString)))

//        Given the code above and your knowledge
//        Create an object Ship with fields: name, color, engineType, age
//        Create a stream of 5 instances of the Ship object
//        a) Sort ship by name.
//                b) Print only ships of orange color
//                c) Print all ship names


    }
}
