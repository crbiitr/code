package com.java.searching;

//  Elements must be in range 1 to n-1
public class FindDuplicate {

	public static void main(String[] args) {
		
//		int array[] = {0,2,0,0,2,3};
		int array[] = {3,2,1,2,2,3};
		CheckDuplicate(array);

	}
	
	static void CheckDuplicate(int array[]) {
		
		int temp=-1;
		for(int i = 0; i < array.length; i++) {
			if(array[Math.abs(array[i])] < 0) {
				System.out.println("Duplicate exist :: " + Math.abs(array[i]));
				return;
			} else {
				array[Math.abs(array[i])] *= -1; 
			}
		}
		System.out.println("No duplicate in the given list");
	}

}
