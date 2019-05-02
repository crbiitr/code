package main.java.com.BehavioralPatterns.memento.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 02/05/19
 */
public class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Saving state " + state + " to memento");
        return new Memento(state);
    }

    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
        System.out.println("Restoring state from Memento, now state is ==> " + state);
    }
}
