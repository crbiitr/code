package com.java.recursion;

class a {
	public int A[] = new int[3];
	
	public void binary(int n) {
		if(n<1) {
			display();
		} else {
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}
	
	public void display() {
		for(int i:A) {
			System.out.print(i);
		}
		System.out.println();
	}
}

public class NbitsUsingBacktrack {

	public static void main(String[] args) {

		a obj = new a();
		obj.binary(3);
	}
	
}
