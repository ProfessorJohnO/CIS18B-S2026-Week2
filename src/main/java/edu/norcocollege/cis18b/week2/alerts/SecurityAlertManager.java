package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecurityAlertManager {

    private final List<SecurityAlert> alerts = new ArrayList<>();
    
    public void addAlert(SecurityAlert alert) {
        if(alert == null){
        throw new IllegalArgumentException("alert cannot be null");
        }
        alerts.add(alert);
    }
    public Optional<SecurityAlert> findById(String id) {
        if (id == null){
        return Optional.empty();
        }
        return alerts.stream()
            .filter(a -> a.id () .equals(id))
            .findFirst();
    }
    
    public List<SecurityAlert> findBySeverity(String severity) {
        if (severity == null){
           return List.of();
        }
        return alerts.stream()
            .filter(a -> a.severity ().equalsIgnoreCase(severity))
            .toList();
    }
    
    public boolean removeAlert(String id) {
        if (id == null){
            return false;
        }
        return alerts.removeIf(a -> a.id().equals(id));
    }
        
    public String getSeverityRecommendation(SecurityAlert alert) {
        if (alert == null){
            throw new IllegalArgumentException("alert cannot be null");
        }

        Object obj = alert;
        if (!(obj instanceof SecurityAlert a)) {
            throw new IllegalArgumentException("Unknown alert type");
        }

        var sev = a.severity();
        if (sev == null) {
            throw new IllegalArgumentException("severity cannot be null");
        }
        return switch (sev.toUpperCase()) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Inversigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> throw new IllegalArgumentException("Unknown severity: " + sev);
        };
    
    }
}
