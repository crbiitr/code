package com.java.selectiveQuestions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 */
public class Problem7 {
    public static void main(String[] args) {
        String date = LocalDateTime.parse("2014-05-04").format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(date);
    }
}
