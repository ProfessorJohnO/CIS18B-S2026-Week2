package edu.norcocollege.cis18b.week2.alerts;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
public class SecurityAlertManager 
{

    // TODO: Declare a private List<SecurityAlert> to store alerts
    private List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    public void addAlert(SecurityAlert alert) 
    {
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) 
    {
        if (id == null) {
            return Optional.empty();
        }
        return alerts.stream()
                     .filter(alert -> id.equals(alert.id())) // changed
                     .findFirst();
    }

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) 
    {
        if (severity == null) {
            return List.of(); // empty list
        }
        return alerts.stream()
                     .filter(alert -> severity.equals(alert.severity())) // changed
                     .toList();
    }

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) 
    {
        return alerts.removeIf(alert -> id != null && id.equals(alert.id())); // changed
    }

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */

public String getSeverityRecommendation(SecurityAlert alert) 
{
    if (alert == null) 
    {
        throw new IllegalArgumentException("Alert cannot be null");
    }

    return switch (alert.severity()) 
    {
        case "LOW" -> "Log and monitor.";
        case "MEDIUM" -> "Investigate within 24 hours.";
        case "HIGH" -> "Escalate to engineering.";
        case "CRITICAL" -> "Immediate incident response required.";
        default -> throw new IllegalArgumentException("Unknown severity: " + alert.severity());
    };
} // end of method
}