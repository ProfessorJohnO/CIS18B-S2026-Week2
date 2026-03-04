package edu.norcocollege.cis18b.week2.demo;

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
        System.out.println("add " + a + " + " + a + "\n"); 
        int sum;
        sum = a + a;
        System.out.println(a + " + " + a + " = " + sum + "\n");
    } 
    
    public void calc(double p) 
    { 
        System.out.println("multiply " + p + " * 2\n");
        double m;
        m = p * 2;
        System.out.println(p + " * 2 = " + m + "\n");
    } 
    
    public void calc(int b, int c) 
    { 
        System.out.println("divide " + b + " by " + c + " to get the answer\n"); 
        double d;
        d = b/c; 
        System.out.println(b + " / " + c + " = " + d + "\n"); 
    } 
    
    public void calc(int e, int f, int g) 
    { 
        System.out.println("subtract " + f + " from " + e + "\n"); 
        int h;
        h = e - f; 
        System.out.println(e + " - " + f + " = " + h + "\n");

        System.out.println("Now Let's add the answer to " + g + "\n");
        int i;
        i = h + g;
        System.out.println(h + " + " + g + " = " + i + "\n");

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }

    // List.of(...)
    
}