package com.java.algorithims.stringAlgorithms.basicOfStringManupulation;

public class Test {
    public static void main(String[] args) {
        System.out.println(solve("acaaabbbacdddd"));
    }

    private static String solve(String str){
        System.out.println("Length: " + str.length());
        char arr[] = str.toCharArray();
        int j = -1;
        for(int i = 0; i < arr.length; ){
            if(j == -1 || arr[j] != arr[i]){
                arr[++j] = arr[i++];
                continue;
            }
            while(i < arr.length && arr[j] == arr[i]){
                i++;
            }
            j--;
        }
        return String.valueOf(arr, 0, j+1);
    }
}
