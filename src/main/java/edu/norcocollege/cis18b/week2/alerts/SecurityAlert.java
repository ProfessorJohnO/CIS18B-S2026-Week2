package edu.norcocollege.cis18b.week2.alerts;

// Replacing public class "SecurityAlert" with a record to create immutable data classes
public record SecurityAlert
(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {}
