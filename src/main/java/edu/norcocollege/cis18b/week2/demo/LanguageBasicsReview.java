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

/** class InvalidRequirementException extends Exception {
     public void invalidRequirement(int m) {
        super(m);
     }
}
*/

class InstanceM {

String s = "";

    public void method(String s) {

        // TODO: Implement demonstration of basic Java features
        // NOTE: Remove the exception below when you've implemented your code
        this.s = s;
    }

}

public class LanguageBasicsReview {

    public static int overloadMethod(int x, int y) {
        return x +y;
    }

    public static double overloadMethod(double x, double y) {
        return x + y;
    }

    public static void staticMethod(){

        System.out.println("Demonstrating a static method. \n");
        
    }

    public void demonstrate() {

        var list = List.of("item 1", "item 2", "item 3",  "item 4", "item 5");

        int[] example = {1, 2, 3};

        InstanceM t = new InstanceM();

        t.method("Demonstaring an instance method. ");

        System.out.println(t.s);

        staticMethod();

        int number1 = overloadMethod(14, 5);
        
        double number2 = overloadMethod(3.34, 4.87);

        System.out.println("This is the result of a overloaded function: " + number1);
        System.out.println("\n This is the result of a overloaded function: " + number2 + "\n");

        System.out.println("Demonstrating a list using List.of(): \n");

        for (var element: list)
        {
            System.out.println(element);
        }

        try {
            System.out.println(example[5]);
        } 
        catch (Exception e){
            System.out.println("\n Selected number goes beyond the array limit \n");
        }

        int percent = 80;

        String grade = switch(percent){

            case 60 -> "D";
            case 70 -> "C";
            case 80 -> "B";
            case 90 -> "A";
            default -> "F";
        };

        System.out.println("Letter grade: " + grade);
    }

}

