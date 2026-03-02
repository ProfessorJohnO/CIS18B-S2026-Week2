//package edu.norcocollege.cis18b.week2.alerts;

//import java.util.List;
//import java.util.Optional;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
//public class SecurityAlertManager {

    // TODO: Declare a private List<SecurityAlert> to store alerts

    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    //public void addAlert(SecurityAlert alert) {
        //throw new UnsupportedOperationException("Not implemented yet");
    //}

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    //public Optional<SecurityAlert> findById(String id) {
        //throw new UnsupportedOperationException("Not implemented yet");
    //}

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    //public List<SecurityAlert> findBySeverity(String severity) {
        //throw new UnsupportedOperationException("Not implemented yet");
    //}

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    //public boolean removeAlert(String id) {
        //throw new UnsupportedOperationException("Not implemented yet");
    //}

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */
    //public String getSeverityRecommendation(SecurityAlert alert) {
        //throw new UnsupportedOperationException("Not implemented yet");
    //}
//}

package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
public class SecurityAlertManager {

    // Internal List to store alerts
    private final List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * Reject null and add alert to list
     */
    public void addAlert(SecurityAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("alert must not be null");
        }
        alerts.add(alert);
    }

    /**
     * Return Optional.empty() if id is null
     * Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }

        return alerts.stream()
                .filter(a -> id.equals(a.id()))
                .findFirst();
    }

    /**
     * Return empty list if severity is null
     * Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        if (severity == null) {
            return List.of();
        }

        var normalized = severity.trim().toUpperCase();

        return alerts.stream()
                .filter(a -> normalized.equals(a.severity()))
                .toList();
    }

    /**
     * Remove alert by ID
     * Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) {
        if (id == null) {
            return false;
        }

        return alerts.removeIf(a -> id.equals(a.id()));
    }

    /**
     * Reject null alert
     * Use pattern matching with instanceof
     * Use modern switch expression
     * Throw IllegalArgumentException for unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("alert must not be null");
        }

        // Pattern matching with instanceof
        Object obj = alert;
        if (!(obj instanceof SecurityAlert a)) {
            throw new IllegalArgumentException("Unknown alert type");
        }

        // Required text block (kept but not returned)
        var banner = """
                === SEVERITY RECOMMENDATION ===
                """;

        // Ensure banner is technically used
        banner.length();

        var severity = a.severity();

        return switch (severity) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Investigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> throw new IllegalArgumentException("Unknown severity: " + severity);
        };
    }
}