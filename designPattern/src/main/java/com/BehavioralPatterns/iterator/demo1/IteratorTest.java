package main.java.com.BehavioralPatterns.iterator.demo1;

import java.util.Iterator;

/**
 * @author Chetan Raj
 * @implNote From Book
 * @since : 19/04/19
 */
public class IteratorTest {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new Item("Item1",10));
        menu.addItem(new Item("Item2",100));
        menu.addItem(new Item("Item3",104));
        menu.addItem(new Item("Item4",102));
        menu.addItem(new Item("Item5",104));

        System.out.println("Displaying Menu");
        Iterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Removing last item returned");
        iterator.remove();

        System.out.println("Displaying Menu");
        iterator = menu.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
