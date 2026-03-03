package edu.norcocollege.cis18b.week2.alerts;

/**
 * SecurityAlert record representing a cybersecurity alert.
 * 
 * @param id Unique identifier for the alert
 * @param sourceSystem System that generated the alert
 * @param severity Alert severity (LOW, MEDIUM, HIGH, CRITICAL)
 * @param description Description of the alert
 * @param timestamp Time the alert occurred (milliseconds since epoch)
 */
public record SecurityAlert(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {
    // Compact constructor for validation (recommended)
    public SecurityAlert {
        // Validate ID
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Alert ID cannot be null or blank");
        }
        
        // Validate sourceSystem
        if (sourceSystem == null || sourceSystem.isBlank()) {
            throw new IllegalArgumentException("Source system cannot be null or blank");
        }
        
        // Validate severity
        if (severity == null || severity.isBlank()) {
            throw new IllegalArgumentException("Severity cannot be null or blank");
        }
        
        // Validate severity is one of the allowed values
        String upperSeverity = severity.toUpperCase();
        if (!(upperSeverity.equals("LOW") || 
              upperSeverity.equals("MEDIUM") || 
              upperSeverity.equals("HIGH") || 
              upperSeverity.equals("CRITICAL"))) {
            throw new IllegalArgumentException(
                "Severity must be LOW, MEDIUM, HIGH, or CRITICAL (got: " + severity + ")"
            );
        }
        
        // Validate description
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        
        // Validate timestamp (optional - can't be in future or too old)
        long now = System.currentTimeMillis();
        if (timestamp <= 0 || timestamp > now + 86400000) { // Not in future > 1 day
            throw new IllegalArgumentException("Invalid timestamp: " + timestamp);
        }
    }
    
    // Helper method to check if alert is CRITICAL
    public boolean isCritical() {
        return "CRITICAL".equalsIgnoreCase(severity);
    }
    
    // Helper method to check if alert is HIGH or CRITICAL
    public boolean isHighPriority() {
        String upperSeverity = severity.toUpperCase();
        return "HIGH".equals(upperSeverity) || "CRITICAL".equals(upperSeverity);
    }
    
    // Override toString for better readability
    @Override
    public String toString() {
        return String.format(
            "SecurityAlert[id=%s, source=%s, severity=%s, desc='%s', time=%d]",
            id, sourceSystem, severity.toUpperCase(), 
            description.length() > 30 ? description.substring(0, 27) + "..." : description,
            timestamp
        );
    }
}