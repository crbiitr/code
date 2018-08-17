package com.java.java8.jodaDateAndTimeApis;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Chetan Raj Bharti
 * @implNote
 */
public class ZoneDemo {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Default Zone Id is: " + zoneId);

        ZoneId zoneId1 = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt = ZonedDateTime.now(zoneId1);
        System.out.println(zdt);
    }
}
