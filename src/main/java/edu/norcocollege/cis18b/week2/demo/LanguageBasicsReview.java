package edu.norcocollege.cis18b.week2.demo;

import java.time.Month;
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

    public void demonstrate() 
    {
        // TODO: Implement demonstration of basic Java features
        // NOTE: Remove the exception below when you've implemented your code
        // throw new UnsupportedOperationException("Not implemented yet");
        System.out.println("\n");
    }

    // Instance Method
    public void InstanceMethod()
    {
        System.out.println("This is an instance method.\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }

    // Static Method
    public static void staticMethod()
    {
        System.out.println("This is a static method!\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }

    // Overloaded Methods
    public void calc(int a) 
    { 
        System.out.println("This is an overloaded method.\n");

        System.out.println("1. Add " + a + " + " + a + "\n"); 
        int sum;
        sum = a + a;
        System.out.println("\t" + a + " + " + a + " = " + sum + "\n\n");
    } 
    
    public void calc(double p) 
    { 
        System.out.println("2. Multiply " + p + " * 2\n");
        double m;
        m = p * 2;
        System.out.println("\t" + p + " * 2 = " + m + "\n\n");
    } 
    
    public void calc(int b, int c) 
    { 
        System.out.println("3. Divide " + b + " by " + c + " to get the answer\n"); 
        double d;
        d = b/c; 
        System.out.println("\t" + b + " / " + c + " = " + d + "\n\n"); 
    } 
    
    public void calc(int e, int f, int g) 
    { 
        System.out.println("4a. Subtract " + f + " from " + e + "\n"); 
        int h;
        h = e - f; 
        System.out.println("\t" + e + " - " + f + " = " + h + "\n");

        System.out.println("4b. Now Let's add the answer to " + g + "\n");
        int i;
        i = h + g;
        System.out.println("\t" + h + " + " + g + " = " + i + "\n\n");

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }

    // List.of(...)/var
    public void Listof()
	{
        // use of var
	    var stringList = List.of("seven", "ate", "nine");
	    
	    System.out.println("Why is six afraid of seven?\n"); 
	    System.out.println("Because " + stringList);
        System.out.println("\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
	}

    // Custom Exception Class
    class NegNumException extends Exception
    {
        public NegNumException(String message)
        {
            super (message);
        }
    }
    
    public void negNum(int num) throws NegNumException
    {
        if (num <= 0)
        {
            throw new NegNumException("Number must be greater than 0.");
        }

        System.out.println("Positive number: " + num + "\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }

    // Modern switch expression
    public void switchExpression()
    {
        String Month = "August";

        String Season = switch (Month)
        {
            case "December", "January", "February" -> "Winter.";

            case "March", "April", "May" -> "Spring.";

            case "June", "July", "August" -> "Summer.";

            case "September", "October", "November" -> "Fall.";

            default -> "Not a month.";
        };

        System.out.println("The Season is " + Season + "\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }    
}