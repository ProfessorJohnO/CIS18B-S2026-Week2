package edu.norcocollege.cis18b.week2.alerts;

// We are using 'record' instead of 'class' here.
// It's a modern Java shortcut for a data container.
public record SecurityAlert(
    String id, 
    String sourceSystem, 
    String severity, 
    String description, 
    long timestamp
) {}