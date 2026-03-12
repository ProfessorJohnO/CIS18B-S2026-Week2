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
    public void greetUser()
    {
        System.out.println("GOODMORNINGGGG!!!");
    }

    public static int add(int num1, int num2)
    {
        return num1 + num2;
    }

    public static double add(double num1, double num2)
    {
        return num1 + num2;
    }

    public static void showNumber(String num)
    {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        try
        {
            int number = Integer.parseInt(num);

            String answer = "";
            for(int nums : numbers)
            {
                switch (nums)
                {
                    case 1:
                        answer += "One \n";
                    case 2:
                        answer += "Two \n";
                    case 3:
                        answer += "Three \n";
                    case 4:
                        answer += "Four \n";
                    case 5:
                        answer += "Five \n";
                    case 6:
                        answer += "Six \n";
                    case 7:
                        answer += "Seven \n";
                    case 8:
                        answer += "Eight \n";
                    case 9:
                        answer += "Nine";
                }
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Not a valid number.");
        }
    }

    class InvalidNumberException extends Exception
    {
        private String message;

        public InvalidNumberException(String message)
        {        
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }
    }

    public void demonstrate()
    {
        // TODO: Implement demonstration of basic Java features
        // NOTE: Remove the exception below when you've implemented your code
        //throw new UnsupportedOperationException("Not implemented yet");
        greetUser();
        add(4, 4);
        add(6.7, 7.6);
        showNumber("8");
    }
}