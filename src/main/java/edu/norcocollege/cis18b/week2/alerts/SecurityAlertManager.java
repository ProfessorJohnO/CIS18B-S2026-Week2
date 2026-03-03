package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * SecurityAlertManager manages a collection of SecurityAlert objects.
 * It provides methods to add, find, remove, and analyze alerts.
 */
public class SecurityAlertManager {

    // Private List to store alerts (using ArrayList for efficiency)
    private List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * Adds a new alert to the manager.
     * 
     * @param alert The alert to add (cannot be null)
     * @throws IllegalArgumentException if alert is null
     */
    public void addAlert(SecurityAlert alert) {
        // Reject null alerts
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        
        // Add alert to internal list
        alerts.add(alert);
        System.out.println("Alert added: " + alert.id());
    }

    /**
     * Finds an alert by its ID using Stream.
     * 
     * @param id The alert ID to search for
     * @return Optional containing the alert if found, Optional.empty() otherwise
     */
    public Optional<SecurityAlert> findById(String id) {
        // Return Optional.empty() if id is null
        if (id == null) {
            return Optional.empty();
        }
        
        // Use streams to find first match
        return alerts.stream()
            .filter(alert -> id.equals(alert.id()))
            .findFirst();
    }

    /**
     * Finds all alerts with the specified severity using Stream.
     * 
     * @param severity The severity level to filter by
     * @return List of matching alerts (empty list if none found or severity is null)
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        // Return empty list if severity is null
        if (severity == null) {
            return new ArrayList<>();
        }
        
        // Use streams to filter by severity (case-insensitive)
        return alerts.stream()
            .filter(alert -> severity.equalsIgnoreCase(alert.severity()))
            .collect(Collectors.toList());
    }

    /**
     * Removes an alert by its ID.
     * 
     * @param id The ID of the alert to remove
     * @return true if an alert was removed, false otherwise
     */
    public boolean removeAlert(String id) {
        // Return false if id is null
        if (id == null) {
            return false;
        }
        
        // Remove alert by ID using removeIf with predicate
        return alerts.removeIf(alert -> id.equals(alert.id()));
    }

    /**
     * Gets a severity-based recommendation using pattern matching and modern switch expression.
     * 
     * @param alert The alert to analyze
     * @return Recommendation string based on severity
     * @throws IllegalArgumentException if alert is null or has unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        // Reject null alert
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        
        // Use pattern matching with instanceof (even though we already know it's SecurityAlert)
        // This demonstrates the feature as required
        if (!(alert instanceof SecurityAlert)) {
            throw new IllegalArgumentException("Object is not a SecurityAlert");
        }
        
        // Get severity (case-insensitive handling)
        String severity = alert.severity().toUpperCase();
        
        // Modern switch expression with arrow syntax
        return switch (severity) {
            case "LOW" -> "Log and monitor. No immediate action required.";
            case "MEDIUM" -> "Investigate within 24 hours. Assign to security team.";
            case "HIGH" -> "Escalate to engineering. Investigate within 4 hours.";
            case "CRITICAL" -> """
                IMMEDIATE INCIDENT RESPONSE REQUIRED!
                - Alert security team immediately
                - Isolate affected systems
                - Begin forensic analysis
                - Notify management
                """;
            default -> throw new IllegalArgumentException(
                "Unknown severity level: " + alert.severity() + 
                ". Must be LOW, MEDIUM, HIGH, or CRITICAL."
            );
        };
    }

    /**
     * Returns all alerts in the manager.
     * 
     * @return A new ArrayList containing all alerts
     */
    public List<SecurityAlert> getAllAlerts() {
        return new ArrayList<>(alerts);
    }

    /**
     * Gets the total number of alerts.
     * 
     * @return The count of alerts
     */
    public int getAlertCount() {
        return alerts.size();
    }

    /**
     * Gets a summary report using text blocks and streams.
     * 
     * @return A formatted report string
     */
    public String generateReport() {
        long lowCount = alerts.stream()
            .filter(a -> "LOW".equalsIgnoreCase(a.severity()))
            .count();
        long mediumCount = alerts.stream()
            .filter(a -> "MEDIUM".equalsIgnoreCase(a.severity()))
            .count();
        long highCount = alerts.stream()
            .filter(a -> "HIGH".equalsIgnoreCase(a.severity()))
            .count();
        long criticalCount = alerts.stream()
            .filter(a -> "CRITICAL".equalsIgnoreCase(a.severity()))
            .count();
        
        return """
            ╔════════════════════════════════════╗
            ║     SECURITY ALERT SYSTEM REPORT   ║
            ╠════════════════════════════════════╣
            ║  Total Alerts: %20d ║
            ║  LOW:          %20d ║
            ║  MEDIUM:       %20d ║
            ║  HIGH:         %20d ║
            ║  CRITICAL:     %20d ║
            ╚════════════════════════════════════╝
            """.formatted(
                alerts.size(),
                lowCount,
                mediumCount,
                highCount,
                criticalCount
            );
    }
}