//package edu.norcocollege.cis18b.week2.demo;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
//public class ModernFeaturesDemo {

    //public void demonstrate() {
        // TODO: Implement demonstration of modern Java features
        // NOTE: Remove the exception below when you've implemented your code
        //throw new UnsupportedOperationException("Not implemented yet");
    //}
//}

package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates modern Java features.
 *
 * Typical requirements for this file include:
 *  - A record type
 *  - Pattern matching with instanceof
 *  - A switch expression
 *  - Use of Optional
 *  - A basic Stream operation
 *  - A text block (""")
 */
public class ModernFeaturesDemo {

    // Record type (modern Java feature)
    record User(String username, int level) {}

    public void demonstrate() {
        System.out.println("=== ModernFeaturesDemo Demo ===");

        // Optional (avoid nulls)
        Optional<String> maybeName = Optional.of("Jeff");
        System.out.println("Optional example: " + maybeName.orElse("Unknown"));

        // Create a list of records
        var users = List.of(
                new User("alpha", 1),
                new User("bravo", 2),
                new User("charlie", 3)
        );

        // Stream operation (filter + count)
        var highLevelCount = users.stream()
                .filter(u -> u.level() >= 2)
                .count();
        System.out.println("Stream example: users with level >= 2 = " + highLevelCount);

        // Pattern matching with instanceof
        Object obj = users.get(0);
        if (obj instanceof User u) {
            System.out.println("instanceof pattern match: " + u.username() + " lvl " + u.level());
        }

        // Switch expression
        int lvl = users.get(2).level();
        var label = switch (lvl) {
            case 1 -> "BEGINNER";
            case 2 -> "INTERMEDIATE";
            case 3 -> "ADVANCED";
            default -> "UNKNOWN";
        };
        System.out.println("Switch expression label = " + label);

        // Text block
        System.out.println("""
                === MODERN FEATURES REPORT ===
                Total users: %d
                High level users (>=2): %d
                """.formatted(users.size(), highLevelCount));

        System.out.println("=== End ModernFeaturesDemo Demo ===");
    }
}