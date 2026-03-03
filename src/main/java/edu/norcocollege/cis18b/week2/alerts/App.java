
package edu.norcocollege.cis18b.week2.alerts;

import java.util.List;

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

        // TODO: Create SecurityAlertManager instance
        SecurityAlertManager manager = new SecurityAlertManager();

        // TODO: Create multiple SecurityAlert records
        var alert1 = new SecurityAlert(
                "A1",
                "Firewall",
                "HIGH",
                "Unauthorized access attempt detected",
                System.currentTimeMillis()
        );

        var alert2 = new SecurityAlert(
                "A2",
                "Server",
                "CRITICAL",
                "Database outage detected",
                System.currentTimeMillis()
        );

        var alert3 = new SecurityAlert(
                "A3",
                "Endpoint",
                "LOW",
                "Antivirus definitions outdated",
                System.currentTimeMillis()
        );

        var alert4 = new SecurityAlert(
                "A4",
                "SIEM",
                "MEDIUM",
                "Suspicious login pattern",
                System.currentTimeMillis()
        );

        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);

        // TODO: Query by severity and print results
        List<SecurityAlert> highAlerts = manager.findBySeverity("HIGH");
        System.out.println("HIGH alerts found: " + highAlerts.size());
        for (var a : highAlerts) {
            System.out.println("- " + a.id() + " | " + a.sourceSystem() + " | " + a.description());
        }

        // Demonstrate lookup by ID (manager method)
        manager.findById("A2").ifPresent(found -> {
            System.out.println("Lookup by ID A2: " + found.description());
            System.out.println("Recommendation: " + manager.getSeverityRecommendation(found));
        });

        // TODO: Print formatted report using text block
        int total = 4;
        int highCount = highAlerts.size();

        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
    }
}