package com.java.searching;

import java.util.Stack;

public class MaxDiffOfTwoPartsOfArray {

	public static void main(String[] args) {
		int[] arr = {4,3,2,5,1};
		System.out.println("Max is :: " + getMax(arr));

	}

	static int getMax(int[] arr) {
		Stack S = getStack(arr);
		int lmax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=arr.length-2;i++ ) {
			if(lmax<arr[i]) lmax = arr[i];
			
			if((Math.abs(lmax-arr[(int)S.peek()]))>max) {
				max = Math.abs(lmax-arr[(int)S.peek()]); 
			}
			
			S.pop();
		}
		return max;
	}
	static Stack<Integer> getStack(int[] array){
		Stack<Integer> S = new Stack<Integer>();
		if(array.length>1) {
			S.push(array.length-1);
		} else {
			return null;
		}
		for(int i=array.length-2;i>=1;i--) {
			if(array[S.peek()]>array[i]) {
				S.push(S.peek());
			} else {
				S.push(i);
			}
		}
		System.out.println(S.toString());
		return S;
	}
}
