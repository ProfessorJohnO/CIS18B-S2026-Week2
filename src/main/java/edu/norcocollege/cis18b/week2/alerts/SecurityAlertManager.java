package edu.norcocollege.cis18b.week2.alerts;

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

    // TODO: Declare a private List<SecurityAlert> to store alerts

    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    public void addAlert(SecurityAlert alert) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}