package edu.norcocollege.cis18b.week2.alerts;

public record SecurityAlert
(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {}