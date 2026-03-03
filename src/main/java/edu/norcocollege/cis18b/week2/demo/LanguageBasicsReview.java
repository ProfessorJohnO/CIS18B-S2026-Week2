package edu.norcocollege.cis18b.week2.demo;

import java.util.list;
/**
 * Language Basics Review
 * Topic: Ankylosaur
 */
public class LanguageBasicsReview {

    public void demonstrate() {
//--------------
// Variable Declarations
// -------------
int age = 68; //million years ago
double length = 6.25; //meters
boolean isCarnivore = false;
String dinosaurName = "Ankylosaurus";
var tailClubs =1; // type inferred as int

System.out.println("Dinosaur Name:" +dinosaurName));
System.out.println("Age:" + age + "million years ago");
System.out.println("Length: " + length + "meters");
System.out.println("Carnivore: " + isCarnivore);
System.out.println("tailClubs: " + tailClubs);
//--------------
// if statement
//--------------
if (isCarnivore) {
    System.out.println(dinosaurName + "eats neat.");
} else {
    System.out.println(dinosaurName + " eats plants.");
}
//------
// Switch expres(modern)
//------
String armorLevel = "heavy";
String armorDescription = switch (armorLevel) {
            case "light" -> "This Ankylosaurus has light armor.";
            case "medium" -> "This Ankylosaurus has medium armor.";
            case "heavy" -> "This Ankylosaurus is heavily armored!";
            default -> "Unknown armor level.";
};

System.out.println(armorDescription);

        // ----------------------------
        // For Loop
        // ----------------------------
        System.out.println("Counting tail swings:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Swing #" + i);
        }

        // ----------------------------
        // List.of()
        // ----------------------------
        List<String> features = List.of("Armor Plates", "Tail Club", "Beaked Mouth");

        System.out.println("Ankylosaurus features:");
        for (String feature : features) {
            System.out.println(feature);
        }