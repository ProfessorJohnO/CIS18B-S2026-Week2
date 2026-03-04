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

    private final List<SecurityAlert> alerts = new ArrayList<>();
    
    public void addAlert(SecurityAlert alert) {
        if(alert==null){
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    
    public Optional<SecurityAlert> findById(String id) {
        if(id==null)
            {
                return Optional.empty();
            }
            return alerts.stream()
                    .filter(alert -> alert.id().equals(id))
                    .findFirst();
    }

    
    public List<SecurityAlert> findBySeverity(String severity) {
        if(severity==null)
        {
            return List.of();
        }
        return alerts.stream()
                .filter(alert -> alert.severity().equalsIgnoreCase(severity))
                .toList();
    }

    
    public boolean removeAlert(String id) {
        return alerts.removeIf(alert -> alert.id().equals(id));
    }

    
    public String getSeverityRecommendation(SecurityAlert alert) {
        if(alert==null)
        {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        return switch (alert.severity()) {
            case "HIGH" -> "Immediate action required";
            case "MEDIUM" -> "Investigate and take action";
            case "LOW" -> "Monitor and review";
            default -> throw new IllegalArgumentException("Unknown severity: " + alert.severity());
        };
    }
}