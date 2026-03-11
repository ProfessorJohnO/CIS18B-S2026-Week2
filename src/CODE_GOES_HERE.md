# Please put all of your Java source code in this directory.
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

/** class InvalidRequirementException extends Exception {
     public void invalidRequirement(int m) {
        super(m);
     }
}
*/

class InstanceM {

String s = "";

    public void method(String s) {

        // TODO: Implement demonstration of basic Java features
        // NOTE: Remove the exception below when you've implemented your code
        this.s = s;
    }

}

public class LanguageBasicsReview {

    public static int overloadMethod(int x, int y) {
        return x +y;
    }

    public static double overloadMethod(double x, double y) {
        return x + y;
    }

    public static void staticMethod(){

        System.out.println("Demonstrating a static method. \n");
        
    }

    public void demonstrate() {

        var list = List.of("item 1", "item 2", "item 3",  "item 4", "item 5");

        int[] example = {1, 2, 3};

        InstanceM t = new InstanceM();

        t.method("Demonstaring an instance method. ");

        System.out.println(t.s);

        staticMethod();

        int number1 = overloadMethod(14, 5);
        
        double number2 = overloadMethod(3.34, 4.87);

        System.out.println("This is the result of a overloaded function: " + number1);
        System.out.println("\n This is the result of a overloaded function: " + number2 + "\n");

        System.out.println("Demonstrating a list using List.of(): \n");

        for (var element: list)
        {
            System.out.println(element);
        }

        try {
            System.out.println(example[5]);
        } 
        catch (Exception e){
            System.out.println("\n Selected number goes beyond the array limit \n");
        }

        int percent = 80;

        String grade = switch(percent){

            case 60 -> "D";
            case 70 -> "C";
            case 80 -> "B";
            case 90 -> "A";
            default -> "F";
        };

        System.out.println("Letter grade: " + grade);
    }

}

#ModernFeaturesDemo

package edu.norcocollege.cis18b.week2.demo;

import java.util.stream.Stream;

import javax.swing.*;



/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/

interface animal {

}
class dog implements animal {

    public void woof()
    {
        System.out.println("woof");
    }

}
class cat implements animal {

    public void meow(){
        System.out.println("meow");
    }
}

public class ModernFeaturesDemo {
       

    // TODO: Implement demonstration of modern Java features
    // NOTE: Remove the exception below when you've implemented your code

        public static void AnimalResolve(animal animal)
        {
            if (animal instanceof cat cat)
            {
                cat.meow();
            }
            if (animal instanceof dog dog)
            {
                dog.woof();
            }
        }

        @SuppressWarnings("deprecation")
        public void demonstrate() {

        Stream<String> basicStream = Stream.of("First", "second", "Third", "fourth", "Fifth");
         
        int percent = 80;

        String grade = "";

        switch (percent){
            case 60: grade = "D";
            break;

            case 70: grade = "C";
            break;

            case 80: grade = "B";
            break;

            case 90: grade = "A";
            break;

            default: grade = "F";
            break;
        }

        System.out.println("Letter grade: " + grade + "\n");

        Student student1 = new Student("Ryan", "Brown", 12345);

        System.out.println("First Name: " + student1.FirstName() + ", Last Name: " + student1.LastName() + ", Student ID: " + student1.StudentID() + " \n");

        animal Animal = new cat();

        AnimalResolve(Animal);

        getPerson number = new getPerson();

        number.getName().ifPresent(val -> {val.toLowerCase();System.out.println( "\n"+ val);});

        basicStream.filter(str -> Character.isUpperCase(str.charAt(0)))
            .forEach(System.out::println);

        JFrame f = new JFrame("textField");

        JLabel l = new JLabel("nothing entered");

        JButton b = new JButton("submit");

        TextCreate te = new TextCreate();

        b.addActionListener(te);
            
        JTextField t = new JTextField(16);

        JPanel p = new JPanel();

        p.add(t);
        p.add(b);
        p.add(l);
        p.add(p);

        f.setSize(300, 300);

        f.show();

    }

}