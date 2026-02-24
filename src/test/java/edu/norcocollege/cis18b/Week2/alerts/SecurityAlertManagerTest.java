package edu.norcocollege.cis18b.week2.alerts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SecurityAlertManagerTest {

    private SecurityAlertManager manager;

    @BeforeEach
    void setUp() {
        manager = new SecurityAlertManager();
    }

    private static SecurityAlert alert(
            String id,
            String sourceSystem,
            String severity,
            String description,
            long timestamp
    ) {
        return new SecurityAlert(id, sourceSystem, severity, description, timestamp);
    }

    @Test
    void addAlert_thenFindById_returnsAlert() {
        var a1 = alert("A-001", "web-gateway", "HIGH", "Suspicious login attempt", 1700000000L);

        manager.addAlert(a1);

        Optional<SecurityAlert> found = manager.findById("A-001");
        assertTrue(found.isPresent(), "Expected alert to be found by ID");
        assertEquals(a1, found.get(), "Found alert should match the added alert");
    }

    @Test
    void findById_missingId_returnsEmptyOptional() {
        Optional<SecurityAlert> found = manager.findById("DOES-NOT-EXIST");
        assertTrue(found.isEmpty(), "Expected Optional.empty for missing ID");
    }

    @Test
    void findBySeverity_returnsOnlyMatchingSeverity() {
        var low = alert("A-100", "endpoint-agent", "LOW", "Minor anomaly", 1700000100L);
        var high1 = alert("A-101", "db", "HIGH", "SQL injection pattern", 1700000200L);
        var high2 = alert("A-102", "web-gateway", "HIGH", "Brute force detected", 1700000300L);
        var crit = alert("A-103", "auth", "CRITICAL", "Privilege escalation", 1700000400L);

        manager.addAlert(low);
        manager.addAlert(high1);
        manager.addAlert(high2);
        manager.addAlert(crit);

        List<SecurityAlert> highs = manager.findBySeverity("HIGH");

        assertEquals(2, highs.size(), "Expected 2 HIGH severity alerts");
        assertTrue(highs.contains(high1), "Expected list to contain high1");
        assertTrue(highs.contains(high2), "Expected list to contain high2");

        // Verify none of the non-HIGH alerts are included
        assertFalse(highs.contains(low), "LOW alert should not be returned for HIGH query");
        assertFalse(highs.contains(crit), "CRITICAL alert should not be returned for HIGH query");
    }

    @Test
    void findBySeverity_noMatches_returnsEmptyList() {
        var low = alert("A-200", "endpoint-agent", "LOW", "Minor anomaly", 1700000100L);
        manager.addAlert(low);

        List<SecurityAlert> criticals = manager.findBySeverity("CRITICAL");
        assertNotNull(criticals, "Should return a non-null list");
        assertTrue(criticals.isEmpty(), "Expected empty list when no alerts match severity");
    }

    @Test
    void removeAlert_existingId_returnsTrue_andAlertIsGone() {
        var a1 = alert("A-300", "web-gateway", "MEDIUM", "Unusual traffic spike", 1700000000L);
        manager.addAlert(a1);

        boolean removed = manager.removeAlert("A-300");
        assertTrue(removed, "Expected removeAlert to return true for existing ID");

        assertTrue(manager.findById("A-300").isEmpty(),
                "Expected alert to be removed and no longer found by ID");
    }

    @Test
    void removeAlert_missingId_returnsFalse() {
        boolean removed = manager.removeAlert("NOPE");
        assertFalse(removed, "Expected removeAlert to return false for missing ID");
    }

    @Test
    void getSeverityRecommendation_returnsExpectedMessages() {
        var low = alert("A-401", "sensor", "LOW", "Low severity test", 1L);
        var med = alert("A-402", "sensor", "MEDIUM", "Medium severity test", 1L);
        var high = alert("A-403", "sensor", "HIGH", "High severity test", 1L);
        var crit = alert("A-404", "sensor", "CRITICAL", "Critical severity test", 1L);

        assertAll(
                () -> assertEquals("Log and monitor.", manager.getSeverityRecommendation(low)),
                () -> assertEquals("Investigate within 24 hours.", manager.getSeverityRecommendation(med)),
                () -> assertEquals("Escalate to engineering.", manager.getSeverityRecommendation(high)),
                () -> assertEquals("Immediate incident response required.", manager.getSeverityRecommendation(crit))
        );
    }

    @Test
    void getSeverityRecommendation_unknownSeverity_throwsOrReturnsDefault() {
        var weird = alert("A-500", "sensor", "WILD", "Unknown severity", 1L);

        assertThrows(IllegalArgumentException.class,
                () -> manager.getSeverityRecommendation(weird),
                "Expected IllegalArgumentException for unknown severity");

    }
}