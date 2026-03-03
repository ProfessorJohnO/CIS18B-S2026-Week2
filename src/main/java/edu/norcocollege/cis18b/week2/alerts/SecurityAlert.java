package edu.norcocollege.cis18b.week2.alerts;

public record SecurityAlert(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
    ){}

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
public class SecurityAlert {
    // TODO: Replace this entire class with a record
}
