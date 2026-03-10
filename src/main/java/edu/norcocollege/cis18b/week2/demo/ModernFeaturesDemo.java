package edu.norcocollege.cis18b.week2.demo;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

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
            System.out.println("This is a record type.\n\n");

            System.out.println("A deck of cards has both " + b + " and " + r + " cards.\n");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        }
        
        // use of optional
        public static Optional<Cards> of(String b, String r)
        {
            if (b.compareTo(r) <= 0)
            {
                return Optional.of(new Cards(b, r));
            }

            else
            {
                return Optional.empty();
            }
        }
    }

    Cards C = new Cards("black", "red");

    // pattern matching instanceof
    public void cell(Object phone)
    {
        if(phone instanceof String s)
        {
            System.out.println("This is pattern matching instanceof.\n\n");

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

        System.out.println("This is a switch expression.\n\n");

        System.out.println("You could watch a(n) " + Genre + " movie like " + Movie + "\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }
    
    // record for stream operation
    record Game(int year, String name){}

    // text block
    public void textBlock()
    {
        String textBlock = """
        This
           is
            a
          text
        block.
        
        
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        
        """;

        System.out.println(textBlock);
    }
}