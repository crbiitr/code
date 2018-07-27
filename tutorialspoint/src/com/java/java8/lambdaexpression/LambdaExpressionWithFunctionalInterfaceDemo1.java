package com.java.java8.lambdaexpression;

interface FInterface1 {
    public void m1();
}

class WithOutLambda1 implements FInterface1 {
    @Override
    public void m1() {
        System.out.println("<-- WITHOUT LAMBDA EXPRESSION -->");
    }
}

interface FInterface2 {
    public void m1(int a, int b);
}

class WithOutLambda2 implements FInterface2 {
    @Override
    public void m1(int a, int b) {
        System.out.println("SUM(a+b): " + (a + b));
    }
}


interface FInterface3 {
    public int square(int x);
}

class WithOutLambda3 implements FInterface3 {
    @Override
    public int square(int x) {
        return x * x;
    }
}

public class LambdaExpressionWithFunctionalInterfaceDemo1 {
    public static void main(String[] args) {
        //Without Lambda Expression
        FInterface1 fInterface1 = new WithOutLambda1();
        fInterface1.m1();

        FInterface2 fInterface2 = new WithOutLambda2();
        fInterface2.m1(2, 5);

        FInterface3 fInterface3 = new WithOutLambda3();
        System.out.println("SQUARE : " + fInterface3.square(2));
        System.out.println("\n\n");


        /*<------------------------------------------------------------>*/
        //By Using Lambda Expression
        FInterface1 fInterfaceWithLambda = () -> System.out.println("<-- WITH LAMBDA EXPRESSION -->");
        fInterfaceWithLambda.m1();

        FInterface2 fInterfaceWithLambda2 = (a, b) -> System.out.println("SUM(a+b): " + (a + b));
        fInterfaceWithLambda2.m1(2,5);

        FInterface3 fInterfaceWithLambda3 = x -> x*x;
        System.out.println("SQUARE : " + fInterfaceWithLambda3.square(2));

    }

}
