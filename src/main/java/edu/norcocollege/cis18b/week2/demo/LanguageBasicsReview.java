package edu.norcocollege.cis18b.week2.demo;
import java.util.List;

public class LanguageBasicsReview {
    static class DemoException extends Exception { public DemoException(String m) { super(m); } }

    public static void main(String[] args) {
        var items = List.of("Java", "Maven");
        try {
            if (items.isEmpty()) throw new DemoException("Empty!");
            items.forEach(System.out::println);
        } catch (DemoException e) { System.err.println(e.getMessage()); }
        
        String result = switch (1) { case 1 -> "Working"; default -> "Error"; };
        System.out.println(result);
    }
}