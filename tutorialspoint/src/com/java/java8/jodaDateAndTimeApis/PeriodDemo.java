package com.java.java8.jodaDateAndTimeApis;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author Chetan Raj Bharti
 * @implNote
 * Period.between(): To get the difference of two LocalDates
 */
public class PeriodDemo {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1989, Month.AUGUST, 04);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDay, currentDate);
        System.out.printf("Your Age is=> %d Years %d Months %d Days ", period.getYears(), period.getMonths(), period.getDays());

        LocalDate DeathDay = LocalDate.of(1989*60, Month.AUGUST, 04);
        Period period1 = Period.between(currentDate,DeathDay);
        int d = period1.getYears()*365+period1.getMonths()*30+period1.getDays();
        System.out.printf("\nLeft time is=> %d Days ", d);

        //Not able to understand the below output, Need to give some more time to understand
        System.out.printf("\nLeft time is=> %d Years %d Months %d Days ", period1.getYears(), period1.getMonths(), period1.getDays());
    }
}
