package com.java.java8.lambdaexpression;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("CHILD THREAD");
        }
    }
}

public class RunnableWithAndWithoutLambdaExpression {
    public static void main(String[] args) {

        //Without Lambda Expression
        System.out.println("<-- WITHOUT LAMBDA EXPRESSION -->");
        MyRunnable r = new MyRunnable();
        Thread th = new Thread(r);
        th.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("MAIN THREAD--->");
        }

        /*<------------------------------------------------------------>*/
        //By Using Lambda Expression
        System.out.println("<-- WITH LAMBDA EXPRESSION -->");
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("CHILD THREAD");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("MAIN THREAD######--->");
        }
    }
}
