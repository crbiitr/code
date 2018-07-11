package com.java.OtherImportantQuestions;

public class CirclePatrolPump {
    public static int P[] = {4, 6, 7, 4};
    public static int D[] = {6, 5, 3, 5};

    /*
    public static int P[] = {6, 3, 7};
    public static int D[] = {4, 6, 3};
    */

    public static void main(String[] args) {
        if (isPossible()) {
            System.out.println("Possible");
        } else {
            System.out.println("Not possible");
        }
    }

    public static boolean isPossible() {
        boolean isPossible = false;
        int count = 0, temp = 0, i = 0;
        int curP = P[i], curD = D[i], n = P.length, start = 0;
        while (count < P.length - 1) {
            temp++;
            if (curP > curD) {
                if (count == 0) {
                    start = i;
                }
                curP += P[(i + 1) % n] - D[i];
                curD = D[(i + 1) % n];
                i = (i + 1) % n;
                count++;
            } else {
                i = (i + 1) % n;
                curP = P[i];
                curD = D[i];
                count = 0;
            }
        }
        if (count == P.length - 1) {
            System.out.println("Start at : " + start);
            isPossible = true;
        }
        return isPossible;
    }

}
