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
public class LanguageBasicsReview 
{

    public static void main(String[] args) 
    {
        new LanguageBasicsReview().demonstrate();
    }

    public void demonstrate() 
    {

        // Variable declarations
        var message = "Java Review";
        int count = 3;

        System.out.println(message);

        // List using List.of()
        List<String> items = List.of("One", "Two", "Three");

        // Control flow - loop
        for (String item : items) 
            {
                System.out.println(item);
            }

        // Modern switch expression
        String result = switch (count) 
        {
            case 1 -> "Single";
            case 2, 3 -> "Few";
            default -> "Many";
        };

        System.out.println("Switch result: " + result);

        // Try/catch with custom exception
        try {
            validateNumber(-5);
        } catch (NegativeNumberException e) 
        {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Calling instance method
        sayHello("Simrah");

        // Calling overloaded method
        sayHello("Simrah", 2);

        // Calling static method
        System.out.println("Sum: " + addNumbers(4, 6));
    }

    // Instance method
    public void sayHello(String name) 
    {
        System.out.println("Hello " + name);
    }

    // Overloaded method
    public void sayHello(String name, int times) 
    {
        for (int i = 0; i < times; i++) {
            System.out.println("Hello " + name);
        }
    }

    // Static method
    public static int addNumbers(int a, int b) 
    {
        return a + b;
    }

    // Method that throws custom exception
    public void validateNumber(int number) throws NegativeNumberException 
    {
        if (number < 0) 
            {
            throw new NegativeNumberException("Number cannot be negative");
        }
    }

    // Custom exception
    static class NegativeNumberException extends Exception 
    {
        public NegativeNumberException(String message) 
        {
            super(message);
        }
    }
}