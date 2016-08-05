package com.java.searching;

//Elements must be in range 0 to n-1
public class MaxOccuringElement {

	public static void main(String[] args) {
		
//		int array[] = {3,2,1,2,2,3};
		int array[] = {0,2,0,0,2,3};
		System.out.println("Maximum repeated value is:: " 
		+ CheckMaxOccuring(array));

	}
	
	static int CheckMaxOccuring(int array[]) {
	
		int max = Integer.MIN_VALUE;
		int maxIndex = max;
		int maxValue = 0;
		for(int i = 0; i < array.length; i++) {
			array[array[i]%array.length] += array.length; 
		}
		
		for(int i = 0; i < array.length; i++) {
			if((array[i]/array.length) > max) {
				maxValue = array[i]%array.length;
				max = array[i]/array.length;
				maxIndex = i;
			}
		}
		System.out.println("Max is :: " + max);
		System.out.println("MaxIndex is :: " + maxIndex);
		System.out.println("MaxValue is :: " + maxValue);
		System.out.println("Max value is :: " + array[max]/array.length);
		return maxIndex;
	}

}
