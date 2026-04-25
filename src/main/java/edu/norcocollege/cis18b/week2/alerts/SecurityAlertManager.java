package edu.norcocollege.cis18b.week2.alerts;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

public class SecurityAlertManager {

    private List<SecurityAlert> alerts = new ArrayList<>();

    public void addAlert(SecurityAlert alert) {
     
        alerts.add(alert);
    }
    //Modern: Returns a "box" (Optional) tha might have an alert 
    public Optional<SecurityAlert> findByID(String Id){
        return alerts.stream().filter(a -> a.id().equalsIgnoreCase(Id)).findFirst();
    }
    // uses a "pipeline" to filter the list
    public List<SecurityAlert> findBySeverity(String severity){
        return alerts.stream().filter(a -> a.severity().equalsIgnoreCase(severity)).toList();
    }
    
    public String getRecommendation(SecurityAlert alert){
        if(alert == null) return "ERROR: No alert provided.";
        return switch (alert.severity().toUpperCase()) {
            case "LOW"      -> "Log and monitor.";
            case "MEDIUM"   -> "Investigate within 24 hours.";
            case "HIGH"     -> "Escalate to Enginnering";
            case "CRITICAL" -> "Immediate incident response required";
            default         ->  "Unknown security level";

        };
        }
        public int getTotalAlertCount(){
            return alerts.size();
        }
    }
        

    