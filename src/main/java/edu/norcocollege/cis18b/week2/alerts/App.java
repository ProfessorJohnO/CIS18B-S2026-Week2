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
public class App 
{

    public static void main(String[] args) 
    {

        // TODO: Create SecurityAlertManager instance
        SecurityAlertManager manager = new SecurityAlertManager();

        // TODO: Create multiple SecurityAlert records
        var alert1 = new SecurityAlert("A001", "Firewall", "LOW", "Suspicious login attempt", System.currentTimeMillis());
        var alert2 = new SecurityAlert("A002", "WebServer", "HIGH", "Multiple failed login attempts", System.currentTimeMillis());
        var alert3 = new SecurityAlert("A003", "Database", "CRITICAL", "Unauthorized data access detected", System.currentTimeMillis());

        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);

        // TODO: Query by severity and print results
        var highAlerts = manager.findBySeverity("HIGH");
        var criticalAlerts = manager.findBySeverity("CRITICAL");

        // Example: Demonstrate getSeverityRecommendation
        System.out.println("Recommendation for alert2: " + manager.getSeverityRecommendation(alert2));

        // TODO: Print formatted report using text block
        int total = 3; // we created 3 alerts
        int highCount = highAlerts.size();
        int criticalCount = criticalAlerts.size();

        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            Critical Severity Alerts: %d
            """.formatted(total, highCount, criticalCount));
    }
}