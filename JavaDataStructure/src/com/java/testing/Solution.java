package com.java.testing;

import java.util.Collections;
/*

public class Solution {
    public static void main(String args[]) {
*/
/*        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int numberOfElement = scanner.nextInt();

        int ar1[] =  new int[numberOfElement];
        int ar2[] = new int[numberOfElement];
        for(int i=0;i<numberOfElement;i++){
            ar1[i]=scanner.nextInt();
            ar2[i] = scanner.nextInt();

        }
        int result = findMax(ar1,ar2);
        System.out.println(result);
        System.out.println(Arrays.toString(ar1));*//*


        int a[] =  {4,2,3,9,7,5,6,8};
        solution(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println( "a[i]:: " + a[i] );
        }
    }

    public static void solution(int a[]) {

        int length = a.length;
        if (length < 0 ) return;

        Stack<Integer> s = new Stack<Integer>();

//s.push(a[0]);

        for (int i = 0; i < length; i++) {

            if(!s.isEmpty()) {
                int top = s.peek();
                if(a[top] > a[i]) {
                    s.push(i);

                } else {
                    a[top] = a[i];
                    s.pop();
                    s.push(i);

                }
            } else {
                s.push(i);
            }
        }

    }





    public static int findMax(int entry[], int exit[]) {
        Arrays.sort(entry);
        Arrays.sort(exit);
        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        int n = entry.length;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival, increment count of
            // platforms needed
            if (entry[i] < exit[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)  // Update result if needed
                    result = plat_needed;
            }
            else // Else decrement count of platforms needed
            {
                plat_needed--;
                j++;
            }
        }



        return result;
    }
}*/

import java.util.ArrayList;

public class Solution {
    public static class Interval implements Comparable<Interval>{
        int first;
        int last;
        private Interval(int s, int e){
            this.first = s;
            this.last = e;
        }

        public int compareTo(Interval i){
            int getend = ((Interval) i).last;
            return this.last - getend;
        }
    }

    public static int findConflictingAppointments(ArrayList<Interval>inter){
        Collections.sort(inter);
        int count = 0;
        for (int i =1;i<inter.size();i++){
            if(inter.get(i).first <= inter.get(i - 1).last){
//                System.out.println(inter.get(i));
                count++;
            }
        }
        return count;
    }

    public static int solution(int[] A, int[]B) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        for (int i = 0; i <A.length ; i++) {
            list.add(new Interval(A[i],B[i]));


        }
        System.out.println(findConflictingAppointments(list));
        System.out.println(list.size());

        return (list.size() - 2*findConflictingAppointments(list) + findConflictingAppointments(list));

    }
    public static void main(String[]  args){
        int A[] = {1,12,42,70,36,-4,43,15};
        int B[] = {5,15,44,72,36,2,69,24};
        System.out.println(solution(A, B));

        interpret("G()()()()(al)");
        int[][] matrix = {  {1,5},
                            {7,3},
                            {3,5}
                        };
        System.out.println("\nMaximum Wealth");
        System.out.println("Result: " + maximumWealth(matrix));

    }


        public static String interpret(String command) {
            char[] a = command.toCharArray();
            StringBuilder sb = new StringBuilder("");

            for(int i = 0; i<a.length; i++) {
                if(a[i]=='G') {
                    sb.append("G");
                } else {
                    if(a[i]=='(') {
                        if (a[i+1]==')') {
                            sb.append("o");
                            i++;
                        } else {
                            sb.append("al");
                            i+=3;
                        }
                    }
                }
            }
            return sb.toString();
    }

    public static int maximumWealth(int[][] accounts) {
        int result = 0;

        for(int[] row:accounts) {
            int rowSum = 0;
            for(int value:row) {
                System.out.print(value + " ");
                rowSum+=value;
            }
            System.out.println();
            if(result<rowSum)
                result = rowSum;
        }
        return result;
    }
}

