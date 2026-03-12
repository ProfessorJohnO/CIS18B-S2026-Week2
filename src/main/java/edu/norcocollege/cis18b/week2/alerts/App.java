package edu.norcocollege.cis18b.week2.alerts;

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
        // Example:
        // var alert1 = new SecurityAlert(...);
        var alert1 = new SecurityAlert(
                "A100",
                "Firewall",
                "HIGH",
                "Suspicious traffic detected",
                System.currentTimeMillis()
        );

        var alert2 = new SecurityAlert(
                "A101",
                "AuthServer",
                "CRITICAL",
                "Multiple failed login attempts",
                System.currentTimeMillis()
        );

        var alert3 = new SecurityAlert(
                "A102",
                "Monitoring",
                "LOW",
                "CPU usage slightly elevated",
                System.currentTimeMillis()
        );

        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);

        // TODO: Query by severity and print results
        var highAlerts = manager.findBySeverity("HIGH");

        var found = manager.findById("A101");

        found.ifPresent(a -> {
            var recommendation = manager.getSeverityRecommendation(a);
            System.out.println("Recommendation: " + recommendation);
        });

        var total = 3;
        var highCount = highAlerts.size();

        // TODO: Print formatted report using text block
        /*
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
        */
       System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
    }
}