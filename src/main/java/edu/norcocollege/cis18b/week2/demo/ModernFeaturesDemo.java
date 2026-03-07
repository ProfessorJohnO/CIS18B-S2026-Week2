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

    // 

}