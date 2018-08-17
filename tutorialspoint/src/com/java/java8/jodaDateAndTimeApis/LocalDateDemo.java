package com.java.java8.jodaDateAndTimeApis;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);

        int dd = date.getDayOfMonth();
        int mm = date.getMonthValue();
        int yyyy = date.getYear();

        System.out.printf("dd-mm-yyyy: %d-%d-%d", dd, mm, yyyy);

    }
}
