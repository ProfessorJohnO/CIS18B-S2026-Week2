package edu.norcocollege.cis18b.week2.alerts;

import java.time.Instant;
import java.util.List;

public class App 
{
    public static void main(String[] args) 
    {

        SecurityAlertManager manager = new SecurityAlertManager();

        var alert1 = new SecurityAlert("A001", "Firewall", "HIGH", "Suspicious login attempt", Instant.now().toEpochMilli());
        var alert2 = new SecurityAlert("A002", "Antivirus", "LOW", "Minor virus detected", Instant.now().toEpochMilli());
        var alert3 = new SecurityAlert("A003", "IDS", "CRITICAL", "Multiple failed logins", Instant.now().toEpochMilli());
        var alert4 = new SecurityAlert("A004", "Firewall", "MEDIUM", "Port scan detected", Instant.now().toEpochMilli());

        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);

        List<SecurityAlert> highAlerts = manager.findBySeverity("HIGH");

        var maybeAlert = manager.findById("A003");
        maybeAlert.ifPresent(alert -> System.out.println("Lookup by ID A003: " + alert.description()));

        System.out.println("""
                === SECURITY ALERT REPORT ===
                Total Alerts: %d
                High Severity Alerts: %d
                """.formatted(manager.getTotalAlerts(), highAlerts.size()));

        for (var alert : List.of(alert1, alert2, alert3, alert4)) 
            {
            System.out.println("""
                    Alert ID: %s
                    Source: %s
                    Severity: %s
                    Recommendation: %s
                    """.formatted(
                    alert.id(),
                    alert.sourceSystem(),
                    alert.severity(),
                    manager.getSeverityRecommendation(alert)
            ));
        }
    }
}