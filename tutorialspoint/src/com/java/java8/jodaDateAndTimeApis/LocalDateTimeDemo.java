package com.java.java8.jodaDateAndTimeApis;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        int dd = dateTime.getDayOfMonth();
        int mm = dateTime.getMonthValue();
        int yyyy = dateTime.getYear();

        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();
        int nano = dateTime.getNano();

        System.out.printf("dd-mm-yyyy::hh:mm:ss:nn %d-%d-%d::%d:%d:%d:%d", dd, mm, yyyy, hour, minute, second, nano);

        LocalDateTime localDateTime = LocalDateTime.of(1989, Month.AUGUST, 04, 12, 50);
        System.out.println("\n\nLocalDateTime using LocalDateTime.Of method: " + localDateTime);

        System.out.println("After Six months: " + localDateTime.plusMonths(6));
        System.out.println("Before Six months: " + localDateTime.minusMonths(6));

    }
}
