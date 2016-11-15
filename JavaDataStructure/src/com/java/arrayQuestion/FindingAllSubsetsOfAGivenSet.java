package com.java.arrayQuestion;
import java.util.Arrays;

public class FindingAllSubsetsOfAGivenSet {
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLACK = 2;

    public static void main(String[] args) {
        int colorArray[] = {2, 2, 2, 1, 0, 1, 1, 0, 1, 2, 1};
        sortBallByColor(colorArray);
        System.out.println("Sorted color Array = " + Arrays.toString(colorArray));

    }

    static void sortBallByColor(int colorArray[]) {
        int start = 0;
        int size = colorArray.length;
        int end = size - 1;
        int current = 0, temp = 0;
        while (current <= end) {
            switch (colorArray[current]) {
                case RED: {
                    temp = colorArray[start];
                    colorArray[start] = colorArray[current];
                    colorArray[current] = temp;
                    start++;
                    current++;
                    break;
                }
                case GREEN:
                    current++;
                    break;
                case BLACK: {
                    temp = colorArray[current];
                    colorArray[current] = colorArray[end];
                    colorArray[end] = temp;
                    end--;
                    break;
                }
            }
        }
    }

}