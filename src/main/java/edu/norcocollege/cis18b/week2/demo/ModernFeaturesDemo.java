package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

public class ModernFeaturesDemo 
{

    public void demonstrate() 
    {

        //  Local record inside method
        record Item(String name, int quantity) {}

        //  Text block
        String intro = """
                Modern Java Features Demo
                - record
                - Optional
                - Streams
                - instanceof pattern matching
                - switch expression
                - text block
                """;
        System.out.println(intro);

        //  var + List.of
        var items = List.of(
                new Item("ItemA", 12),
                new Item("ItemB", 8),
                new Item("ItemC", 3)
        );

        //  Stream operation: sum quantities
        int totalQuantity = items.stream()
                .mapToInt(Item::quantity)
                .sum();
        System.out.println("Total quantity: " + totalQuantity);

        //  Optional usage: find first item with quantity <= 5
        Optional<Item> maybeSmall = items.stream()
                .filter(i -> i.quantity() <= 5)
                .findFirst();
        Object mystery = maybeSmall.orElse(new Item("No small item", 0));

        //  Pattern matching with instanceof
        if (mystery instanceof Item i) {
            System.out.println("Pattern matched: " + i.name() + " (" + i.quantity() + ")");
        }

        //  Modern switch expression
        String sizeCategory = switch (Integer.compare(totalQuantity, 20)) 
        {
            case -1 -> "small batch";
            case 0 -> "exactly 20 units";
            default -> "large batch";
        };
        System.out.println("Batch size: " + sizeCategory);
    }

    public static void main(String[] args) 
    {
        var demo = new ModernFeaturesDemo();
        demo.demonstrate();
    }
}