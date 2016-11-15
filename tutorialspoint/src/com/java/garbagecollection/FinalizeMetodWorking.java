package com.java.garbagecollection;

/**
 * Created by user on 11/2/16.
 */
public class FinalizeMetodWorking {

    public static void main(String[] args) {

        int i = 0;
        while(i<1000000) {
            FinalizeMetodWorking a = new FinalizeMetodWorking();
            FinalizeMetodWorking b = new FinalizeMetodWorking();
            FinalizeMetodWorking c = new FinalizeMetodWorking();
            i++;
            System.out.println("i : " + i);
        }

    }
    @Override
    public void finalize() {
        System.out.println("GoodBye");
//        System.exit(0);
    }
}
