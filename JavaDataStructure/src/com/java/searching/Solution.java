package com.java.searching;

import java.util.Arrays;
import java.util.Stack;

class Solution {
	
	public static void main(String []args) {
		int T[] = {9,1,4,9,0,4,8,9,0,1};
		int B[] = solution(T);
		printArray(B);
	}
    public static int[] solution(int[] T) {
        int capital = -1;
        int B[] = new int[T.length];
        
        for(int i=0;i<T.length-1;i++){
            if(T[i]==i){
                capital = i;    
            }    
        }
        
        for(int i=0;i<T.length-1;i++){
            int c=0;
            int index = i;
            while(index!=i){
                int temp = T[index];
                index = temp;
                c++;
            }
            B[i] = c;
        }
        printArray(B);
        for(int i=0;i<T.length-1;i++){
            T[i]=0;    
        }
        
        for(int i=0;i<T.length-1;i++){
            if(B[i]>0){
                T[B[i]-1]++;    
            }
        }
        printArray(T);
        return T;
    }
    
    static void printArray(int a[]) {
		for(int i:a) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}
