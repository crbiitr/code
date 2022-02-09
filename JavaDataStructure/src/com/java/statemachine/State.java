package com.java.statemachine;

public class State implements IState{

    private long stateId;
    private String stateName;
    private boolean isEndState;
    private boolean isStartState;
    private INotification notification;
    private long failureStateId;
    private long successStateId;
    private long exceptionStateId;

    public State() {
    }

    public State(long stateId, String stateName, boolean isEndState, boolean isStartState, INotification notification, long failureStateId, long successStateId, long exceptionStateId) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.isEndState = isEndState;
        this.isStartState = isStartState;
        this.notification = notification;
        this.failureStateId = failureStateId;
        this.successStateId = successStateId;
        this.exceptionStateId = exceptionStateId;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean isEndState() {
        return isEndState;
    }

    public void setEndState(boolean endState) {
        isEndState = endState;
    }

    public boolean isStartState() {
        return isStartState;
    }

    public void setStartState(boolean startState) {
        isStartState = startState;
    }

    public INotification getNotification() {
        return notification;
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
    }

    public long getFailureStateId() {
        return failureStateId;
    }

    public void setFailureStateId(long failureStateId) {
        this.failureStateId = failureStateId;
    }

    public long getSuccessStateId() {
        return successStateId;
    }

    public void setSuccessStateId(long successStateId) {
        this.successStateId = successStateId;
    }

    public long getExceptionStateId() {
        return exceptionStateId;
    }

    public void setExceptionStateId(long exceptionStateId) {
        this.exceptionStateId = exceptionStateId;
    }

    @Override
    public int process() {
        // On Success return 1;
        // On failure return 2;
        // On Exception return 3;
        return 1;
    }
}
