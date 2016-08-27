package com.java.dynamicProgramming;

/**
 * Created by user on 8/24/16.
 */
public class Wordcount {

    public static void main (String[] args) {

        System.out.println("Simple Java Word Count Program");
        String str1 = "word count function";
        int count = 0;
        String[] wCount = str1.split(" ");

        for (int i = 0; i < wCount.length; i++) {

            if (!wCount[i].isEmpty()) {
                count++;
            }

        }

        System.out.println(count);

        String str = "line1\nline2\nline3\rline4";
        System.out.println(str);
        int count1 = getLineCount(str);
        System.out.println("line count: "+count1);

    }


    public static int getLineCount(String text){

        return text.split("[\n|\r]").length;
    }


}
