package edu.norcocollege.cis18b.week2.demo;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo 
{

    public void runDemo() 
    {
        // 1. Local variable type inference (var)

        var message = "Hello, modern Java!";
        System.out.println("Message: " + message);

        // 2. Switch expressions (modern style)

        int dayOfWeek = 3;
        String dayName = switch (dayOfWeek) 
        {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Unknown";
        };
        System.out.println("Day of week: " + dayName);

        // 3. Pattern matching with instanceof
       
        Object obj = "I am a string";
        if (obj instanceof String s) {
            System.out.println("Pattern matching: " + s.toUpperCase());
        }

        // 4. Records (simple immutable data class)
        
        record Person(String name, int age) {}
        Person p = new Person("Alice", 25);
        System.out.println("Record example: " + p.name() + ", age " + p.age());

        // 5. Text blocks (multi-line strings)
        
        String json = """
                      {
                          "name": "Bob",
                          "age": 30
                      }
                      """;
        System.out.println("Text block example:\n" + json);

        // 6. Optional example
 
        java.util.Optional<String> optional = java.util.Optional.of("I exist");
        optional.ifPresent(s -> System.out.println("Optional value: " + s));
    }
}