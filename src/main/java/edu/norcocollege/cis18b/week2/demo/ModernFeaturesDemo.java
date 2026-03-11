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
