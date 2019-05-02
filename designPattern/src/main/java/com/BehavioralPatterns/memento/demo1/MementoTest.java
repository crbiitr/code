package main.java.com.BehavioralPatterns.memento.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 02/05/19
 */
public class MementoTest {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("State 1");
        originator.setState("State 2");
        caretaker.addMemento(originator.saveToMemento());

        originator.setState("State 3");
        caretaker.addMemento(originator.saveToMemento());

        originator.setState("State 4");
        caretaker.addMemento(originator.saveToMemento());

        originator.restoreFromMemento(caretaker.getMemento(0));
    }
}
