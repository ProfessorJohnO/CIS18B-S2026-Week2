package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

import edu.norcocollege.cis18b.week2.demo.LanguageBasicsReview.NegNumException;
import edu.norcocollege.cis18b.week2.demo.ModernFeaturesDemo.Cards;
import edu.norcocollege.cis18b.week2.demo.ModernFeaturesDemo.Game;

/**
 * DemoApp is a simple test harness to run the Week 1 demo classes:
 * - LanguageBasicsReview
 * - ModernFeaturesDemo
 *
 * This is NOT a replacement for JUnit tests. It's a quick way to
 * run/observe output while you're developing.
 *
 * TODO (Required):
 *  - Instantiate LanguageBasicsReview and call demonstrate()
 *  - Instantiate ModernFeaturesDemo and call runDemo()
 *  - Print clear section headers so output is easy to read
 *
 * TODO (Optional/Stretch):
 *  - Add simple timing (System.nanoTime) around each demo
 *  - Catch exceptions so one demo failing doesn’t stop the other
 */
public class DemoApp {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" Week 1 Demo Harness");
        System.out.println("========================================");

        // ------------------------------------------------------------
        // Demo 1: Language Basics Review
        // ------------------------------------------------------------
        System.out.println();
        System.out.println(">>> Demo 1: LanguageBasicsReview");
        System.out.println("----------------------------------------");

        var basics = new LanguageBasicsReview();
        basics.demonstrate();

        // call Instance Method
        basics.InstanceMethod();
        
        // call Static Method
        LanguageBasicsReview.staticMethod();

        // call Overloaded Method
        LanguageBasicsReview calc = new LanguageBasicsReview();
        
            calc.calc(25);
            calc.calc(3.14);
            calc.calc(144, 12);
            calc.calc(10, 5, 15);

        // call listof method
        basics.Listof();

        // call try/catch with custom exception
        try
        {
            basics.negNum(-4);
        }
            catch(NegNumException e)
            {
                System.out.println("Caught Exception: " + e.getMessage());
                System.out.println("\n");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            }

        // call modern switch expression
        basics.switchExpression();


        // ------------------------------------------------------------
        // Demo 2: Modern Features Demo
        // ------------------------------------------------------------
        System.out.println();
        System.out.println(">>> Demo 2: ModernFeaturesDemo");
        System.out.println("----------------------------------------");

        var modern = new ModernFeaturesDemo();
        modern.demonstrate();

        // call pattern matching instanceof
        String phone = "Samsung";

        modern.cell(phone);

        // call switch expression
        modern.expression();

        // call optional
        String b = "black";
        String r = "red";

        Optional<Cards> c = Cards.of(b, r);
        c.ifPresent(color -> System.out.println("This is the use of optional.\n\n\n"
            + "A deck of cards has both " + b + " and " + r + " cards.\n\n" 
            + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"));

        // stream operation
        List<Game> games  = List.of(
            new Game(2017, "Fortnite"),
            new Game(2019, "Apex Legends"),
            new Game(2020, "Call of Duty: Warzone"),
            new Game(2021, "Super Animal Royale")
        );

        int year = 2017;
        String name =
            games.stream()
                .filter(game -> game.year() == year)
                .findFirst()
                .map(Game::name)
                .orElse("UNKNOWN");
        System.out.println("This is a stream operation.\n\n\n" + 
            "Name of game with year of release \"" + name + "\" : " + year + "\n\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

        // call text block
        modern.textBlock();        

        // ------------------------------------------------------------
        // Done
        // ------------------------------------------------------------
        System.out.println();
        System.out.println("========================================");
        System.out.println(" Done. Review output above.");
        System.out.println("========================================");
    }
}