package edu.norcocollege.cis18b.week2.alerts;
import java.util.*;

public class SecurityAlertManager {
    private final List<SecurityAlert> alerts = new ArrayList<>();
    public void addAlert(SecurityAlert a) { alerts.add(a); }
    public Optional<SecurityAlert> findById(String id) { return alerts.stream().filter(a -> a.id().equals(id)).findFirst(); }
    public List<SecurityAlert> findBySeverity(String s) { return alerts.stream().filter(a -> a.severity().equalsIgnoreCase(s)).toList(); }
    public String getSeverityRecommendation(SecurityAlert a) {
        return switch (a.severity().toUpperCase()) {
            case "LOW" -> "Log and monitor.";
            case "CRITICAL" -> "Immediate response required.";
            default -> "Investigate.";
        };
    }
}