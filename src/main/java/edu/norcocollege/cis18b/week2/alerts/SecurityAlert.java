//package edu.norcocollege.cis18b.week2.alerts;

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
//public class SecurityAlert {
    // TODO: Replace this entire class with a record
//}

package edu.norcocollege.cis18b.week2.alerts;

public record SecurityAlert(
        String id,
        String sourceSystem,
        String severity,
        String description,
        long timestamp
) {

    // compact constructor for validation
    public SecurityAlert {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be blank");
        }

        if (sourceSystem == null || sourceSystem.isBlank()) {
            throw new IllegalArgumentException("sourceSystem must not be blank");
        }

        if (severity == null || severity.isBlank()) {
            throw new IllegalArgumentException("severity must not be blank");
        }

        if (description == null) {
            throw new IllegalArgumentException("description must not be null");
        }

        // Normalize severity to uppercase
        severity = severity.toUpperCase();
    }
}