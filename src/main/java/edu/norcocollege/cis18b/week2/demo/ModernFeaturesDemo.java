package edu.norcocollege.cis18b.week2.demo;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo {

    public void demonstrate() {
        // TODO: Implement demonstration of modern Java features
        // NOTE: Remove the exception below when you've implemented your code
        // throw new UnsupportedOperationException("Not implemented yet");
    }

    // record type
    public record Cards(String b, String r) 
    { 
        public Cards
        {
            System.out.println("\nA deck of cards has both " + b + " and " + r + " cards.\n");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        }
    }

    Cards C = new Cards("black", "red");

    // pattern matching instanceof
    public void cell(Object phone)
    {
        if(phone instanceof String s)
        {
            System.out.println("You have a(n) " + s + " phone.\n");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        }
    }

    // switch expression
    public void expression()
    {
        String Genre = "action";

        String Movie = switch (Genre)
        {
            case "horror" -> "The Conjuring.\n";

            case "action" -> "John Wick";

            case "comedy" -> "Ted";

            case "animation" -> "How To Train You Dragon";

            default -> "Any Movie.";

        };

        System.out.println("You could watch " + Movie + "\n");

    }
}