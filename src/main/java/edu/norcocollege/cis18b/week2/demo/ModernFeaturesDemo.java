package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo {

    public record Student(String name, int score) {}
    public void demonstrate() {
        // TODO: Implement demonstration of modern Java features
        // NOTE: Remove the exception below when you've implemented your code
        String intro = """
        This demo will be my way showcasing some modern Java features, including:
        - Records: A way to define immutable data classes.
        - Pattern Matching: Simplifies type checks.
        - Switch Expressions: A more powerful and flexible switch statement.
        - Operations on Collections: Using streams and lambda expressions for functional-style operations.
        - Stream: A powerful tool for processing collections of data in a functional style.
        - Text Blocks: A convenient way to create multi-line string literals without needing escape sequences.
        """;

        System.out.println(intro);


        var students = List.of(new Student("Ethan",95),new Student("Alex",82),new Student("Kaylee",67));
        double average = students.stream().mapToInt(Student::score).average().orElse(0);

        System.out.println("Average score: " + average);
         
        Optional<Student> topStudent = students.stream()
                .filter(s -> s.score() > 90)
                .findFirst();

        topStudent.ifPresentOrElse(
                s -> System.out.println("Top student: " + s.name()),
                () -> System.out.println("No top student found.")
        );
        
        
        Object obj = new Student("Taylor", 50);
        
        if (obj instanceof Student s) {
            System.out.println("Pattern matched student: " + s.name());
        }
        

        var grade = letterGrade(95);
        System.out.println("Score: 95, Letter Grade: " + grade);

        grade = letterGrade(55);
        System.out.println("Score: 55, Letter Grade: " + grade);

        
    }
    private String letterGrade(int score){
            return switch (score / 10) 
            {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };
        }
}