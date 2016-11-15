package com.java.algorithims.stringAlgorithms.basicOfStringManupulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by user on 11/10/16.
 */
public class CompilerVersion {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        String line;
        StringBuilder builder = new StringBuilder();
        while((line = br.readLine()) != "") {
            Character previous = null;
            int i = 0;
            int length = line.length();
            char[] charArray = line.toCharArray();
            boolean newLineAdded = false;
            while(i < length) {
                if(previous == null) {
                    previous = charArray[i];
                    i++;
                    continue;
                } else if (previous == '/' && charArray[i] == '/') {
                    builder.append(previous);
                    while(i < length) {
                        builder.append(charArray[i]);
                        i++;
                    }
                    builder.append('\n');
                    newLineAdded = true;
//                    line = br.readLine();
                    break;
                } else if (previous == '-' && charArray[i] == '>') {
                    builder.append('.');
                    previous = null;
                    i++;

                } else {
                    builder.append(previous);
                    previous = charArray[i];
                    i++;
                }

            }
//            System.out.print("Line::  " +line + "  Builder::  "+builder.toString());
            if (newLineAdded == false) {
                builder.append(previous);
            }
        }
        System.out.print(builder.toString());

    }
}
