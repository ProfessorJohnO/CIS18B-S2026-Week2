package edu.norcocollege.cis18b.week2.demo;

public class LanguageBasicsReview {

    public void demonstrate() {
        int age = 23;
        double height = 6.1;
        String name = "Ikhlas";
        boolean isStudent = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student? " + isStudent);

        if (age >= 18) {
            System.out.println("You are an adult."); }
            else {
                System.out.println("You are a minor."); }

        switch (name) {
            case "Ikhlas":
                System.out.println("Hello Ikhlas");
                break;
            default:
                System.out.println("Hello There"); }

        for (int i = 1; i <=3; i++) {
            System.out.println("Loop iteration: " + i);
        } 
        
        greet("world");

        Person p = new Person("Ronaldo", 40);
        p.introduce();
        
    }
    
    private void greet(String who) {
        System.out.println("Hi " + who + "!"); }

    
    class Person {
        String name;
        int age;

        Person(String n, int a) {
            name = n;
            age = a;            }

        
       void introduce() {
        System.out.println("Hi, my name is " + name + "and I am " + age + " years old.");
       }     
    }    

}