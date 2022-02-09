package com.java.statemachine;

import java.util.HashMap;
import java.util.Map;

public class Transition {
    // Cache Map: <StateId, State>
    public HashMap<Long, State> stateMap = new HashMap<>();
    private State currentState;
    private State nextState;
    public Transition transition;

    public Transition() {
        transition = this;
    }

    public Transition(HashMap<Long, State> stateMap, State currentState, State nextState, Transition transition) {
        this.stateMap = stateMap;
        this.currentState = currentState;
        this.nextState = nextState;
        this.transition = transition;
    }

    public Map<Long, State> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<Long, State> stateMap) {
        this.stateMap = stateMap;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    // Transition Start
    public void execute(State state) {
        currentState = state;
        int stateResult = state.process();
        System.out.println("Running State::" + state.getStateId());

        long nextStateId;
        switch (stateResult) {
            case 1: //Success
                nextStateId = state.getSuccessStateId();
                break;
            case 2: //Failure
                nextStateId = state.getFailureStateId();
                break;
            case 3: //Exception
                nextStateId = state.getExceptionStateId();
                break;
        }

        nextState = stateMap.get(state.getSuccessStateId());
        if(!currentState.isEndState()) {
            transition.execute(nextState);
        }

    } // End
}
