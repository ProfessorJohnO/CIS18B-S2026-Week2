package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo {

    public void demonstrate() {
        record Bouquet (String name, int stems){}

        String intro = """
                Modern Java Features Demo 
                - record 
                - Optional
                - streams
                - instanceof pattern matching
                - switch expression
                - text block
                """;
       System.out.println(intro);

       var bouquets = List.of(
                new Bouquet("Roses", 12),
                new Bouquet("Tulips", 8),
                new Bouquet("Sunflowers", 3)
       );

       int totalStems = bouquets.stream()
                .mapToInt(Bouquet::stems)
                .sum();
       System.out.println("Total stems: " + totalStems);

       Optional<Bouquet> maybeSmall = bouquets.stream()
                .filter(b -> b.stems() <= 5)
                .findFirst();
       Object mystery = maybeSmall.orElse(new Bouquet("No small bouquet",0));

       if(mystery instanceof Bouquet b){
            System.out.println("Pattern matched: " + b.name() + "(" + b.stems() + " stems)");
       }

       String size = switch (Integer.compare(totalStems, 20)) {
            case -1 -> "small order";
            case 0 -> "exactly 20 stems";
            default -> "big order";
       };
       System.out.println("Order size: " + size);
    }
}