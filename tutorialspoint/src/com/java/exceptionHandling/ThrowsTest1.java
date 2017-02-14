package com.java.exceptionHandling;

import java.io.IOException;

/**
 * Created by user on 2/3/17.
 * Note: checked exceptions can be propagated by throws keyword.
 */
public class ThrowsTest1 {
    void m()throws IOException{
        throw new IOException("device error");//checked exception
    }
    void n()throws IOException {
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handled, Message-----> " + e.getMessage());}
    }
    public static void main(String args[]){
        ThrowsTest1 obj=new ThrowsTest1();
        obj.p();
        System.out.println("normal flow...");
    }
}
