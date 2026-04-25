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
        var alert1 = new SecurityAlert("001", "Firewall", "CRITICAL", "DDos Attack detected", System.currentTimeMillis());
        var alert2 = new SecurityAlert("002", "Auth-Server","HIGH", "BRUTE Force attempt",System.currentTimeMillis());
        var alert3 = new SecurityAlert("003", "Workstation-10", "LOW", "Unknown USB plugged in", System.currentTimeMillis());
        
        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        
        // TODO: Query by severity and print results
        System.out.println("---Searching for CRITICAL ALERTS---");
        var criticalAlerts = manager.findBySeverity("CRITICAL");
        for(var alert : criticalAlerts){
            System.out.println("ID:  " + alert.id() + "   | Description " + alert.description());
        }


        // TODO: Print formatted report using text block
        
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(3, criticalAlerts.size()));
        
    }
}