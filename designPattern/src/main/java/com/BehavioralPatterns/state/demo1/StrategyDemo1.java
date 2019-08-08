package main.java.com.BehavioralPatterns.state.demo1;

/**
 * @author Chetan Raj
 * @implNote Not happy with this example, from the book.
 * @since : 2019-08-07
 */
public class StrategyDemo1 {
    public static void main(String[] args) {
        MusicPlayerContext musicPlayer = new MusicPlayerContext(new StandbyState());
        musicPlayer.requestPlay();
        musicPlayer.setState(new PlayingState());
        musicPlayer.requestPlay();
    }
}


interface State {
    void pressPlay(MusicPlayerContextInterface context);
}

class StandbyState implements State {
    @Override
    public void pressPlay(MusicPlayerContextInterface context) {
        context.setState(new PlayingState());
    }
}

class PlayingState implements State {
    @Override
    public void pressPlay(MusicPlayerContextInterface context) {
        context.setState(new StandbyState());
    }
}

interface MusicPlayerContextInterface {
    // State state;

    void requestPlay();

    void setState(State state);

    State getState();
}

class MusicPlayerContext implements MusicPlayerContextInterface {
    State state;

    public MusicPlayerContext(State state) {
        this.state = state;
    }

    @Override
    public void requestPlay() {
        state.pressPlay(this);
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return state;
    }
}