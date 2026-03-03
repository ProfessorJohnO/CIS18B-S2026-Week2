package edu.norcocollege.cis18b.week2.demo;
import java.util.List;

public class LanguageBasicsReview 
{
    
    // exceptions
    static class InvalidNumberException extends Exception 
    {
        public InvalidNumberException(String message) 
        {
            super(message);
        }
    }
    
    //instance
    public void greet(String name)
    {
        System.out.println("Hello, " + name);
    }

    //static
    public static int add(int a, int b)
    {
        return a + b;
    }

    //overload
    public static double add(double a, double b)
    {
        return a + b;
    }

    //mondern switch
    public static String checkNumber(int number)
    {
        return switch (number)
        {
            case 0 -> "Zero";
            case 1, 2, 3 -> "Small Number";
            default -> "Large number";
        };
    }

    //throws custom exceptions
    public static void validateNumber(int number) throws InvalidNumberException
    {
        if (number < 0)
        {
            throw new InvalidNumberException("Number cannot be negative.");
        }
    }

    public void demonstrate() 
    {
        //var demonstration
        var number = 5;
        var message = "Java Review";

        System.out.println("Number: " + number);
        System.out.println("Message: " + message);

        //instance method call
        greet("Student");

        //static + overload
        System.out.println("Add ints: " + add(3, 4));
        System.out.println("Add doubles: " + add(3.5, 4.5));

        //list.of
        var numbers = List.of(1, 2, 3, 4);
        System.out.println("List: " + numbers);

        //try/catch custom expceptions
        try 
        {
            validateNumber(-1);
        }
        catch (InvalidNumberException e)
        {
            System.out.println("Caught exception: " + e.getMessage());
        }
        //swtich expression
        System.out.println("Check number: " + checkNumber(2));
    }

    public static void main(String[] args) 
    {
       var review = new LanguageBasicsReview();
       review.demonstrate();
    }
}