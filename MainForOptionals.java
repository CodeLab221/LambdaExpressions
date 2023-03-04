package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainForOptionals {
    public static void main(String[] args) {

        Optional<String> stingOptional = Optional.ofNullable("ll");
//        Optional.of(null);
//        Optional.ofNullable(null);
        String s = stingOptional.get(); // would get the value from optional

        String anotherString = stingOptional.orElse("AnotherString");
        System.out.println(stingOptional.isPresent());

        List<Integer> ints = List.of(1,2,3,4,6,8,9,11,20,5);

        Stream<Integer> stream = ints.stream().sorted(); // Stream
        stream.collect(Collectors.toList());
        stream.forEach(number -> System.out.println(number));

        ints.forEach(inte -> {

        });

        ints.stream().forEach(inte -> {

        });

        stingOptional.stream()
                .forEach(System.out::println);

    }

}
