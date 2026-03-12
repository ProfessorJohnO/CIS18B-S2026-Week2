package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo
{
    record Student(String name, int grade)
    {

    }

    public static void main(String[] args)
    {
        // Text block
        String message = """
                Modern Java Features Demo
                This program shows records, streams,
                optionals, and switch expressions.
                """;
        System.out.println(message);

        // Create a list of students
        List<Student> students = List.of(
                new Student("Alex", 90),
                new Student("Sam", 75),
                new Student("Jordan", 85));

        // Basic Stream operation
        students.stream()
                .filter(s -> s.grade() > 80)
                .forEach(s -> System.out.println(s.name() + " passed with a high grade"));

        // Use of Optional
        Optional<Student> first = students.stream().findFirst();
        first.ifPresent(s -> System.out.println("First student: " + s.name()));

        // Pattern matching with instanceof
        Object obj = new Student("Taylor", 88);

        if (obj instanceof Student s)
        {
            System.out.println("Pattern matched student: " + s.name());
        }

        // Switch expression
        int score = 85;
        String result = switch (score / 10)
        {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            default -> "Needs improvement";
        };

        System.out.println("Grade category: " + result);
    }


    public void demonstrate()
    {
        // TODO: Implement demonstration of modern Java features
        // NOTE: Remove the exception below when you've implemented your code
        //throw new UnsupportedOperationException("Not implemented yet");
    }
}