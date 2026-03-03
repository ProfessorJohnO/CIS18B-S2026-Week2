
package edu.norcocollege.cis18b.week2.demo;

import java.util.List;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 *
 * TODO:
 *  - Demonstrate variable declarations and types
 *  - Demonstrate control flow (if, switch, loops)
 *  - Demonstrate methods and parameters
 *  - Demonstrate basic OOP concepts (classes, objects, inheritance)
 */
public class LanguageBasicsReview {

    // Custom exception class
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public void demonstrate() {

        System.out.println("=== LanguageBasicsReview Demo ===");

        // Variable declarations and types
        int age = 20;
        double gpa = 3.7;
        boolean isStudent = true;
        var school = "Norco College";   

        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Student: " + isStudent);
        System.out.println("School: " + school);

        // List.of(...)
        var names = List.of("Aisha", "Ben", "Ali");

        // Control flow 
        if (!names.isEmpty()) {
            System.out.println("We have names in the list.");
        }

        for (var name : names) {
            System.out.println(greet(name));
        }

        // Overloaded method usage
        System.out.println(greet("Jeff", 3));

        // Modern switch expression
        int level = 2;
        var levelName = switch (level) {
            case 1 -> "Beginner";
            case 2 -> "Intermediate";
            case 3 -> "Advanced";
            default -> "Unknown";
        };
        System.out.println("Level: " + levelName);

        // try/catch example
        try {
            validateName("   ");
        } catch (InvalidInputException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Static method
        System.out.println("5 + 7 = " + add(5, 7));

        // Basic OOP and inheritance
        Animal animal = new Dog("Bolt");
        animal.speak();

        System.out.println("=== End Demo ===");
    }

    // Static method
    public static int add(int a, int b) {
        return a + b;
    }

    // Overloaded methods
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public String greet(String name, int times) {
        return "Hello, " + name + "! (greeted " + times + " times)";
    }

    private void validateName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Name must not be blank.");
        }
    }

    
    private static class Animal {
        void speak() {
            System.out.println("Animal sound");
        }
    }

    private static class Dog extends Animal {
        private final String name;

        Dog(String name) {
            this.name = name;
        }

        @Override
        void speak() {
            System.out.println("Dog " + name + " says woof!");
        }
    }
}