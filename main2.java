package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainForPractice {

    public static void main(String[] args) {


        List<String> names = List.of("John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn");
        List<Integer> numbers = List.of(1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50);
        


        // We use streams to sort array names. We use method .sorted() to process the stream 
    //  Collect method collects the stream data and we can apply .toList method which will
    //  arrange the data into an ouput as a sorted list.
        List<String> sortedNames= names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);
       
        // We use .filter with .startsWith method to get string value that start with he. 
    // The output we apply the same process as before. 
        List<String> namesStartingWithE = names.stream()
                .filter(name -> name.startsWith("E"))
                .collect(Collectors.toList());
        System.out.println("Names starting with E: " + namesStartingWithE);

        // We use .filter to get values beteen 30 and 200 and print them.
        List<Integer> filteredNumbers = numbers.stream()
                .filter(number -> number > 30 && number < 200)
                .collect(Collectors.toList());
        System.out.println("Numbers 30 to  200: " + filteredNumbers);

        // 
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Names in upper case: " + upperCaseNames);

        //  
        List<String> modifiedNames = names.stream()
                .map(name -> name.substring(1, name.length() - 1))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Modified names: " + modifiedNames);

        // 
        List<String> reverseSortedNames = names.stream()
                .sorted(Comparator.comparing(String::toString).reversed())
                .collect(Collectors.toList());
        System.out.println("Names in reverse: " + reverseSortedNames);

     }}
