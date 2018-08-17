package com.java.java8.jodaDateAndTimeApis;

import java.time.Year;

/**
 * @author Chetan Raj Bharti
 * @implNote
 * Year: To check some functionality of year.
 */
public class YearClassDemo {
    public static void main(String[] args) {
        int[] years = {2000, 1988, 1980, 2007, 2018};

        for (int y : years) {
            if (Year.isLeap(y)) {
                System.out.printf("%d is a leap year.", y);
            } else {
                System.out.printf("%d is not a leap year.", y);
            }
            System.out.println();
        }
    }
}
