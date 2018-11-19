package com.java.algorithims.Arrays;

import java.util.Scanner;

/**
 * Created by B0204104 on 19/11/18.
 */
public class MaximizeTheEarning {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int numberOfBuildings = scanner.nextInt();
            int price = scanner.nextInt();

            int[] buildingsHeight= new int[numberOfBuildings];
            for (int j = 0; j < numberOfBuildings; j++) {
                buildingsHeight[j]= scanner.nextInt();
            }
            int finalPrice = getEarning(buildingsHeight,price);
            System.out.println(finalPrice);
        }
    }

    public static int getEarning(int[] buildingsHeight, int price) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < buildingsHeight.length; i++) {
            if(buildingsHeight[index]<buildingsHeight[i]) {
                count++;
                index=i;
            }
        }
        return count*price;
    }
}
