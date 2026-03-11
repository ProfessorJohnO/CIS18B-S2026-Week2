package edu.norcocollege.cis18b.week2.demo;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModernFeaturesDemo {
    //record
    public record Person(String name, int age) { }
    // main
    public static void main(String[] args) {
        ModernFeaturesDemo demo = new ModernFeaturesDemo();
        demo.demonstrate();
    }
    public void demonstrate() {
        // Record usage
        Person p = new Person("Alice", 25);
        System.out.println("Name: " + p.name() + ", Age: " + p.age());
        Object obj = "Hello World";
        if (obj instanceof String s) {
            System.out.println("String length: " + s.length());
        }
        // switch
        var day = "TUESDAY";
        var result = switch (day) {
            case "MONDAY" -> "Start";
            case "TUESDAY" -> "Continue";
            default -> "Other";
        };
        System.out.println(result);
        Optional<String> optionalName = Optional.ofNullable("Bob");
        System.out.println(optionalName.orElse("No name"));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        var squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squared);
        // Text
        String json = """
                      {
                          "name": "Charlie",
                          "age": 30
                      }
                      """;
        System.out.println(json);
    }
}