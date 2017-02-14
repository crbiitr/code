package com.java.threads;

import java.util.concurrent.*;

/**
 * Created by user on 12/17/16.
 */
public class FectorialUsingCallableInterface {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("Submitted callable task to calculate factorial of 10;");
        Future result10 = executor.submit(new FactorialCalculator(10));

        System.out.println("Submitted callable task to calculate factorial of 15;");
        Future result15 = executor.submit(new FactorialCalculator(15));

        System.out.println("Submitted callable task to calculate factorial of 20;");
        Future result20 = executor.submit(new FactorialCalculator(20));


        System.out.println("Calling get method of Future to fetch results of factorial of 10");
        long fact10 = (long) result10.get();
        System.out.println("Factorial of 10 is : " + result10.get());

        System.out.println("Calling get method of Future to fetch results of factorial of 10");
        long fact15 = (long) result15.get();
        System.out.println("Factorial of 15 is : " + result15.get());

        System.out.println("Calling get method of Future to fetch results of factorial of 10");
        long fact20 = (long) result20.get();
        System.out.println("Factorial of 20 is : " + result20.get());

        executor.shutdown();

    }
}


class FactorialCalculator implements Callable<Long> {

    int number;
    @Override
    public Long call() throws Exception {
        return factorial(number);
    }

    public FactorialCalculator(int number) {
        this.number = number;
    }

    public long factorial(int number) throws InterruptedException {
        long fact = 1;

        while (number != 0) {
            fact = fact * number;
            number--;
            Thread.sleep(100);
        }

        return fact;
    }
}

