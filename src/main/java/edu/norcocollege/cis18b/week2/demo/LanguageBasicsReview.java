package edu.norcocollege.cis18b.week2.demo;

import java.util.List;


/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 *
 * TODO:
 *  - Demonstrate variable declarations and types
 *  - Demonstrate control flow (if, switch, loops)
 *  - Demonstrate methods and parameters
 *  - Demonstrate basic OOP concepts (classes, objects, inheritance)
 */
public class LanguageBasicsReview {
        

        static class InvalidGradeException extends Exception 
        {
            public InvalidGradeException(String message) {
                super(message);
            }
        }
        
        
        class Triangle
        {
            public final int angle;
            public final int sideA;
            public final int sideB;

            public Triangle(int theAngle, int sideLengthA, int sideLengthB)
            {
                this.angle=theAngle;
                this.sideA=sideLengthA;
                this.sideB=sideLengthB;

                
            }

            //Instance Method
            public int getAngle()
            {
                return angle;
            }

            public static int getArea(int sideA, int sideB)
            {
                return (sideA*sideB)/2;
            }
            
            
        }
        static class gradeBookClass
        {
            public int score(String letterGrade) throws InvalidGradeException
            {
                return switch(letterGrade.toUpperCase())
                {
                    case "A" -> 100;
                    case "B" -> 85;
                    case "C" -> 75;
                    case "D" -> 65;
                    case "F" -> 50;
                    default -> throw new InvalidGradeException("Unknown");
                };
            }
            public int score(int points) throws InvalidGradeException
            {
                if(points < 0 || points >100)
                {
                    throw new InvalidGradeException("Points must be between 0 and 100");
                }
                return points;
            }

        }
          public void demonstrate() {
         
        var triangle = new Triangle(90,5,7);// 'var' used here
        var gradeBook = new gradeBookClass();
        var grades = List.of("A", "B", "Q", "C");

        System.out.println("Triangle angle: " + triangle.getAngle());
        System.out.println("Triangle area: " + Triangle.getArea(5, 7));
        for (var g : grades) { // 'var' used here
        // --- try/catch block ---
        try 
        {
            var result = gradeBook.score(g); // overloaded method call (String)
            System.out.println("Grade " + g + " = " + result);
        } catch (InvalidGradeException e) {
            System.out.println("Error: '" + g + "': " + e.getMessage());
            }
        }

         try {
            System.out.println("Numeric score: " + gradeBook.score(92));
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}