package main.java.com.BehavioralPatterns.memento.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 02/05/19
 */
public class Caretaker {
    private List<Memento> savedStates = new ArrayList<>();

    public Memento getMemento(int index) {
        System.out.println(savedStates.get(index));
        return savedStates.get(index);
    }

    public void addMemento(Memento memento) {
        savedStates.add(memento);
    }
}
