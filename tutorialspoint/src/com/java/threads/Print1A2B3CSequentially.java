package com.java.threads;

import java.util.Arrays;

/**
 * Created by chetan on 15/3/17.
 */

class myPrintClass implements Runnable
{

    char[] x = {'a','b','c','d','e','f','g','h','i','j'};

    @Override
    public void run() {
// TODO Auto-generated method stub

        for(int i =0; i< 10;i++)
        {
            System.out.print(i + " ");
            MyprintAplha ma = new MyprintAplha(x[i]);
            Thread t2 = new Thread(ma);
            t2.start();
        }

    }

}
class MyprintAplha implements Runnable
{

    private char cc;
    public MyprintAplha(char c)
    {
        cc = c;

    }
    @Override
    public void run() {
// TODO Auto-generated method stub
        System.out.println(cc + " ");

    }

}

public class Print1A2B3CSequentially {
    public static void main(String[] s) throws InterruptedException
    {

        myPrintClass mp = new myPrintClass();
        Thread t1 = new Thread(mp);
        t1.start();
    }
}