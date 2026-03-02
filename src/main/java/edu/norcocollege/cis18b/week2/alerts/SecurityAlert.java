package edu.norcocollege.cis18b.week2.alerts;

/**
 * TODO:
 *  - Convert this class into a Java 17+ record
 *  - Include the following fields:
 *      String id
 *      String sourceSystem
 *      String severity
 *      String description
 *      long timestamp
 *
 *  - (Optional stretch) Add validation in a compact constructor
 */
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
public record SecurityAlert (String id, String sourceSystem, String severity, String description, long timestamp) {}
public class Main {
    public static void main(String[] args) {
        SecruityAlert A = new



    }
}