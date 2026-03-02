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
import java.util.List;
import java.util.Optional;
public record SecurityAlert(
        String id,
        String sourceSystem,
        String severity,
        String description,
        long timestamp) {}
class SecurityAlertManager {
    private final List<SecurityAlert> alerts = new ArrayList<>();
    // alert
    public void addAlert(SecurityAlert alert) {
        alerts.add(alert);
    }
    //alert by ID Optional
    public Optional<SecurityAlert> findById(String id) {
        return alerts.stream()
                .filter(a -> a.id().equals(id))
                .findFirst();
    }
    // Find alerts using stream
    public List<SecurityAlert> findBySeverity(String severity) {
        return alerts.stream()
                .filter(a -> a.severity().equals(severity))
                .toList();
    }
    // Remove alert
    public boolean removeAlert(String id) {
        return alerts.removeIf(a -> a.id().equals(id));
    }
    public String getSeverityRecommendation(SecurityAlert alert) {
        return switch (alert.severity()) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Investigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> throw new IllegalArgumentException(
                "Unknown severity: " + alert.severity()
            );
        };
    }
    public List<SecurityAlert> getAllAlerts() {
        return alerts;
    }
}

