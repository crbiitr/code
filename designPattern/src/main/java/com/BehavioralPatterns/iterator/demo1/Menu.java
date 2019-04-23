package main.java.com.BehavioralPatterns.iterator.demo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chetan Raj
 * @implNote This Menu is Concrete Aggregate(Container).
 * @since : 19/04/19
 */
public class Menu {
    List<Item> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    public void addItem(Item item) {
        menu.add(item);
    }

    public Iterator<Item> iterator() {
        return new MenuIterator();
    }

    /**
     * It is concrete iterator. Which inherits Java Iterator.
     */
    public class MenuIterator implements Iterator<Item> {
        int currentIndex = 0;

        public Item first() {
            return menu.get(currentIndex);
        }

        @Override
        public boolean hasNext() {
            if (currentIndex >= menu.size())
                return false;
            else
                return true;
        }

        @Override
        public Item next() {
            return menu.get(currentIndex++);
        }

        public Item currentItem() {
            return menu.get(currentIndex);
        }

        public void remove() {
            menu.remove(--currentIndex);
        }
    }
}
