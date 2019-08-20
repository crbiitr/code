package main.java.com.BehavioralPatterns.visitor.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-20
 */
public class VisitorTest {
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Computer(20000, "s1234"),
                new Computer(1249, "s888"),
                new Printer(1000, 6, "HP"),
                new Printer(975, 3, "Dell")
        };

        int totalCost = calculatePrice(items);
        System.out.println("Total cost:: " + totalCost);
    }

    private static int calculatePrice(Item[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (Item item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
