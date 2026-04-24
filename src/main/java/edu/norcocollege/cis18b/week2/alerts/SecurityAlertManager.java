package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;

public class SecurityAlertManager {

    private List<SecurityAlert> alerts = new ArrayList<>();

    public void addAlert(SecurityAlert alert) {
     
        alerts.add(alert);
    }
    public SecurityAlert findById(String id){

        for (int i =0; i < alerts.size(); i++){
            SecurityAlert current = alerts.get(i);

            if (current.id().equals(id)){

                return current;
            }
        }
            return null;
    }
    public List<SecurityAlert> findBySeverity(String severity) {
        List<SecurityAlert> matches = new ArrayList<>();
        for(SecurityAlert alert: alerts ) {
            if(alert.severity().equalsIgnoreCase(severity)) {
                matches.add(alert);
            }
        }
        return matches;
    }
    public String getRecommendation(SecurityAlert alert){
            //guard clause checks if alert is null before anything else. 
            if(alert == null) {
                return "ERROR: no data provided.";
            }

            String level = alert.severity();
            if(level.equalsIgnoreCase("CRITICAL")){
                return "SHUT DOWN SYSTEM: Potential breach in progress.";
            }
            else if (level.equalsIgnoreCase("HIGH")){
                return "ESCALATE: Contact security engineering.";
            }
            else if (level.equalsIgnoreCase("MEDIUM")){
                return "INVESTIGATE: Review logs within 24 hours.";
            }
            else {
                return "MONITOR: No immediate action needed.";
            }

        }

}

