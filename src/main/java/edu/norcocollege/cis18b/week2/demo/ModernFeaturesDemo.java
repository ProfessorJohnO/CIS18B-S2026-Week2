package edu.norcocollege.cis18b.week2.demo;
import java.util.Optional;

public class ModernFeaturesDemo {
    public record User(String name) {}
    public static void main(String[] args) {
        Object obj = new User("Student");
        if (obj instanceof User u) System.out.println("Hello, " + u.name());
        
        System.out.println("""
            Multi-line
            Text Block
            """);
    }
}