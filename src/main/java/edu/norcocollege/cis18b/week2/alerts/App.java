package edu.norcocollege.cis18b.week2.alerts;
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

        // TODO: Create SecurityAlertManager instance
        SecurityAlertManager manager = new SecurityAlertManager();

        // TODO: Create multiple SecurityAlert records
        // Example:
        // var alert1 = new SecurityAlert(...);

        var alert1 = new SecurityAlert("A001", "Authsystem", "LOW", "User logged in from a new device.", System.currentTimeMillis());
        var alert2 = new SecurityAlert("A002", "Authsystem", "MEDIUM", "Multiple failed login attempts detected for user admin from IP 192.168.1.25", System.currentTimeMillis());
        var alert3 = new SecurityAlert("A003", "Antivirus", "HIGH", "System Infected: Backdoor Trojan Activity", System.currentTimeMillis());
        var alert4 = new SecurityAlert("A004", "NetworkMonitor", "CRITICAL", "High volume of outbound traffic detected to external IP 203.0.113.5", System.currentTimeMillis());

        // TODO: Add alerts to manager

        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);


        // TODO: Query by severity and print results
        
        var lowSeverity = manager.findBySeverity("LOW");
        var mediumSeverity = manager.findBySeverity("MEDIUM");
        var highSeverity = manager.findBySeverity("HIGH");
        var criticalSeverity = manager.findBySeverity("CRITICAL");

        System.out.println("\n");
        System.out.println("results for alert1: LOW - " + manager.getSeverityRecommendation(alert1));
        System.out.println("results for alert2: MEDIUM - " + manager.getSeverityRecommendation(alert2));
        System.out.println("results for alert3: HIGH - " + manager.getSeverityRecommendation(alert3));
        System.out.println("results for alert4: CRITICAL - " + manager.getSeverityRecommendation(alert4));
               

        // TODO: Print formatted report using text block
        /*
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
        */

        int total = 4;
        int highCount = 1;

        System.out.println
        (
            """
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d

            """.formatted(total, highCount)
        );
    }
}