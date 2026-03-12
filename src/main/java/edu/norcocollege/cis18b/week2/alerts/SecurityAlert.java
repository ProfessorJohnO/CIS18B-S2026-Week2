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

public record SecurityAlert(
        String id,
        String sourceSystem,
        String severity,
        String description,
        long timestamp) 
        
{
    public SecurityAlert
    {
        if (id == null || id.isBlank())
        {
            throw new IllegalArgumentException("Alert id cannot be null or blank");
        }

        if (severity == null || severity.isBlank())
        {
            throw new IllegalArgumentException("Severity cannot be null");
        }
    }
}