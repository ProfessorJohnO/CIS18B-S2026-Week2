package edu.norcocollege.cis18b.week2.alerts;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.norcocollege.cis18b.week2.alerts.SecurityAlert;
import edu.norcocollege.cis18b.week2.alerts.SecurityAlertManager;

/**
 * Entry point for Week 1.
 *
 * TODO:
 *  - Create at least 3 SecurityAlert objects
 *  - Add them to SecurityAlertManager
 *  - Print a formatted report using a text block
 *  - Demonstrate calling at least one manager method
 */
public class App {

    public static void main(String[] args) {
        
        SecurityAlertManager  manager = new SecurityAlertManager();
        // TODO: Create multiple SecurityAlert records
        // Example:
        // var alert1 = new SecurityAlert(...);

        var alert1 = new SecurityAlert("1", "Firewall", "HIGH", "Unauthorized access attempt detected", System.currentTimeMillis());
        var alert2 = new SecurityAlert("2", "IDS", "MEDIUM", "Suspicious network activity observed", System.currentTimeMillis());
        var alert3 = new SecurityAlert("3", "Antivirus", "LOW", "Malware signature detected", System.currentTimeMillis());

        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);

        // TODO: Query by severity and print results
        var highSeverityAlerts = manager.findBySeverity("HIGH");
        System.out.println("High Severity Alerts: " + highSeverityAlerts.size());
        // TODO: Print formatted report using text block
        /*
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
        */
        int total = manager.findBySeverity("HIGH").size() + manager.findBySeverity("MEDIUM").size() + manager.findBySeverity("LOW").size();
        int highCount = manager.findBySeverity("HIGH").size();
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
      
    }
}