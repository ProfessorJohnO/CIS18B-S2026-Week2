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
public class LanguageBasicsReview {

    static class FlowerCareException extends RuntimeException{
        FlowerCareException(String message){
            super(message);
        }
    }

    public int totalPlants(int roses, int tulips) {
        return roses + tulips;
    }

    public static String flowerCheer(String flower) {
        return "Keep growing, " + flower + " ";
    }

    public static int parseNumber(String text) {
      return Integer.parseInt(text);
    }

    public static int parseNumber(String text, int fallback) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }
    
    public static int safeWaterLevel(int level) {
        try{
            if (level < 0) throw new FlowerCareException("Water level can't be negative: " + level);
            return level;
        } catch (FlowerCareException ex) {
            System.out.println("Handled: " + ex.getMessage() + " -> using 0 instead.");
            return 0;
        }
    }

    public static String careTip(String flowerName) {
        return switch (flowerName.toLowerCase()) {
            case "rose" -> "Roses: prune dead blooms and watch for aphids.";
            case "tulip" -> "Tulips: keep soil moist but not soggy.";
            case "sunflower"-> "Sunflowers: give them sun +support if windy.";
            default -> "General tip: morning watering is usually best.";
        };
    }
    
    public void demonstrate() {
        var gardener = "Ava"; 
        int waterLevel = 3;
        double soilPH = 6.4;
        boolean isSunny = true;
        char flowerCode = 'R';

        System.out.println("Flower Care Helper for " + gardener);

        List<String> flowerBed = List.of("Rose", "Tulip", "Sunflower", "Daisy");
        System.out.println("Flower bed: " +flowerBed);

        if (soilPH < 6.0){
            System.out.println("Soil is a bit acidic. Consider adding some garden lime.");
        } else if (soilPH > 7.5){
            System.out.println("Soil is leaning alkaline. Consider compost or sulfur-based amendments.");
        } else {
            System.out.println("Soil pH looks good for many flowers!");
        }
        System.out.println("Daily checklist:");
        for (int i = 0; i < flowerBed.size(); i++){
            System.out.println(" " + (i + 1) + ") Check " + flowerBed.get(i) + " for drooping leaves");
        }
        String flowerTip = switch (flowerCode){
            case 'R' -> "Roses: prune dead blooms and watch for aphids.";
            case 'T' -> "Tulips: keep soil moist but not soggy.";
            case 'S' -> "Sunflowers: give them sun +support if windy.";
            default -> "General tip: morning watering is usually best.";
        };
        System.out.println(flowerTip);

        System.out.println(flowerCheer("Rose"));
        System.out.println("Total plants: " + totalPlants (4, 6));
        System.out.println("parseNumber(\"12\") = " + parseNumber("12"));
        System.out.println("parseNumber(\"oops\", 0) = " + parseNumber("oops", 0));
        System.out.println("safeWaterlevel (-3) = " + safeWaterLevel(-3));
        System.out.println("Care tip: " +careTip("Tulpi"));
        
        System.out.println("Sun status: " + (isSunny? "Sunny " : "Cloudy "));
        System.out.println("Water level stored: " + waterLevel);
        }

        public static void main(String[] args){
            new LanguageBasicsReview().demonstrate();
        }
}