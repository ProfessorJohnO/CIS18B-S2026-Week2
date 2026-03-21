package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
public class SecurityAlertManager {

    // TODO: Declare a private List<SecurityAlert> to store alerts

    private List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    public void addAlert(SecurityAlert alert) {
        // throw new UnsupportedOperationException("Not implemented yet");

        if (alert == null)
        {
            throw new IllegalArgumentException("Alert is null and rejected.\n\n");
        }

        alerts.add(alert);        
    }

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) {
        // throw new UnsupportedOperationException("Not implemented yet");

        if (id == null)
        {
            return Optional.empty();
        }

        else
        {
            return alerts.stream()
                .filter(alerts ->id.equals(alerts.id()))
                .findFirst();
        }
    }

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        // throw new UnsupportedOperationException("Not implemented yet");

        if (severity == null)
        {
            return List.of();
        }

        else
        {
            return alerts.stream()
                .filter(alerts->severity.equals(alerts.severity()))
                .toList();
        }
    }

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) {
        // throw new UnsupportedOperationException("Not implemented yet");

        if (!(id == null))
        {
            return alerts.removeIf(alerts->alerts.id().equals(id));
        }

        else
        {
            return false;
        }
    }

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        // throw new UnsupportedOperationException("Not implemented yet");

        if (alert == null)
        {
            throw new IllegalArgumentException("Alert is null and rejected.\n\n");
        }

        else
        {
            return switch (alert.severity())
            {
                case "LOW" -> "Log and monitor.\n\n";

                case "MEDIUM" -> "Investigate within 24 hours.\n\n";

                case "HIGH" -> "Escalate to engineering.\n\n";

                case "CRITICAL" -> "Immediate incident response required.\n\n";

                default -> throw new IllegalArgumentException("Unknown severity.\n\n");
            };
        }

    }
}