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
import java.util.List;
public class LanguageBasicsReview {
    static class MyException extends Exception { }
    // main method
    public static void main(String[] args) {
        LanguageBasicsReview review = new LanguageBasicsReview();
        review.demonstrate();
    }
    //  method
    public void demonstrate() {
        // var
        var text = "Hello Professor";
        System.out.println(text);
        // list
        var list = List.of("9", "2", "3");
        System.out.println(list);
        System.out.println(staticMethod(5));
        System.out.println(overloadedMethod(10));
        System.out.println(overloadedMethod("Test"));
        // switch
        var day = "Monday";
        var result = switch (day) {
            case "Monday" -> "Start";
            default -> "Other";
        };
        System.out.println(result);
        // try block
        try {
            check(-1);
        } catch (MyException e) {
            System.out.println("Exception caught");
        }
    }
    // static method
    public static int staticMethod(int x) {
        return x * 2;
    }
    // overloaded methods
    public String overloadedMethod(int x) {
        return "Number";
    }
    public String overloadedMethod(String x) {
        return "String";
    }
    // method exception
    public void check(int num) throws MyException {
        if (num < 0) {
            throw new MyException();
        }
    }
}