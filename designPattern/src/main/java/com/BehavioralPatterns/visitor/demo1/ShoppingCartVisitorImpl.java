package main.java.com.BehavioralPatterns.visitor.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-08-20
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(Computer computer) {
        int cost = 0;
        if (computer.getCost() > 15000) {
            cost = computer.getCost() - 50;
        } else {
            cost = computer.getCost();
        }
        System.out.println("Computer serialNumber: " + computer.getSerialNumber() + ", cost: " + cost);
        return cost;
    }

    @Override
    public int visit(Printer printer) {
        int cost = printer.getPriceOfCartridge() * printer.getNoOfCartridge();
        System.out.println("Printer: " + printer.getModelNumber() + ", cost = " + cost);
        return cost;
    }
}
