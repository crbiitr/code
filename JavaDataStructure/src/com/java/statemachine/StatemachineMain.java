package com.java.statemachine;

import java.util.HashMap;

public class StatemachineMain {

    public static void main(String[] args) {
        // List of States
        // Create a Cache MAP for state <StateId, State>
        HashMap<Long, State> stateHashMap = new HashMap<>();
        // Create a Cache MAP for Notification <NotificationId, State>
        // Create a Transition flow

        INotification smsNotification = new SMSNotification();
        /*State s1 = new State(1, "ProfileData", false, true, smsNotification,4,2,5);
        State s2 = new State(2, "PAN", false, false, smsNotification,4,3,5);
        State s3 = new State(3, "AADHAAR", true, false, smsNotification,4,0,5);*/

        State s1 = new State(1, "ProfileData", false, true, smsNotification,4,3,5);
        State s2 = new State(2, "PAN", false, false, smsNotification,4,3,5);
        State s3 = new State(3, "AADHAAR", true, false, smsNotification,4,0,5);

        stateHashMap.put(s1.getStateId(),s1);
        stateHashMap.put(s2.getStateId(),s2);
        stateHashMap.put(s3.getStateId(),s3);

        Transition transition = new Transition(stateHashMap,s1,null, null);
        transition.setTransition(transition);


        transition.execute(transition.getCurrentState());

    }




}
