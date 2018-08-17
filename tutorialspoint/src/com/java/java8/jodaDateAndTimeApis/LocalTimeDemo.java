package com.java.java8.jodaDateAndTimeApis;

import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nano = localTime.getNano();

        System.out.printf("%d:%d:%d:%d", hour, minute, second, nano);
    }
}
