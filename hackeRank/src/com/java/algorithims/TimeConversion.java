package com.java.algorithims;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-10
 */
public class TimeConversion {
    public static void main(String[] args) {
        String time = "12:00:00PM";
        System.out.println(timeConversion(time));
    }

    static String timeConversion(String s) {
        Map<String, String> map = new HashMap();
        initiateMap(map);

        String []sArray = s.split(":");
        String timeFormat = sArray[2].substring(2,4);
        String result = null;
        String hh,mm,ss = null;
        if(timeFormat.equals("AM")) {
            if(sArray[0].equals("12")) {
                hh = "00";
            } else {
                hh = sArray[0];
            }
        } else {
            if(sArray[0].equals("12")) {
                hh = sArray[0];
            } else {
                hh = map.get(sArray[0]);
            }
        }
        result = hh+":"+sArray[1]+":"+sArray[2].substring(0,2);
        return result;

    }

    static void initiateMap(Map<String, String> map) {
        map.put("01","13");
        map.put("02","14");
        map.put("03","15");
        map.put("04","16");
        map.put("05","17");
        map.put("06","18");
        map.put("07","19");
        map.put("08","20");
        map.put("09","21");
        map.put("10","22");
        map.put("11","23");
    }
}
