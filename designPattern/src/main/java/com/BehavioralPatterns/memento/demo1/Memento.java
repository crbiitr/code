package main.java.com.BehavioralPatterns.memento.demo1;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 02/05/19
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "state='" + state + '\'' +
                '}';
    }

    public String getSavedState() {
        return state;
    }
}
