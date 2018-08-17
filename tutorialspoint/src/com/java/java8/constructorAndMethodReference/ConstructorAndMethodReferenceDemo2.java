package com.java.java8.constructorAndMethodReference;

public class ConstructorAndMethodReferenceDemo2 {
    public static void main(String[] args) {

        //By Using Lambda expression
        /*
        Runnable r = ()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("++++Child Method++++");
            }
        };
        Thread thread = new Thread(r);
      */

        //By Using method reference
        ConstructorAndMethodReferenceDemo2 obj = new ConstructorAndMethodReferenceDemo2();
        Runnable runnable = obj::method1;
        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("#####Main Thread#####");
        }


    }

    public void method1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("++++Child Method++++");
        }
    }
}
