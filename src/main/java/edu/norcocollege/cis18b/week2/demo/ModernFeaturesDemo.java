package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ModernFeaturesDemo
 */
public class ModernFeaturesDemo {
    public void demonstrate() {

        // ----------------------------
        // 1. Record type
        // ----------------------------
        record Dinosaur(String name, boolean carnivore, int age) {}
        var ankylosaurus = new Dinosaur("Ankylosaurus", false, 68);

        System.out.println("Record Dinosaur: " + ankylosaurus);

        // ----------------------------
        // 2. Pattern matching with instanceof
        // ----------------------------
        Object obj = ankylosaurus;
        if (obj instanceof Dinosaur dino) {
            System.out.println(dino.name() + " is " + (dino.carnivore() ? "a carnivore" : "an herbivore"));  
    }
}