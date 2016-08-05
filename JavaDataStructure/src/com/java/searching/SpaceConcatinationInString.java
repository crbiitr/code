package com.java.searching;

public class SpaceConcatinationInString {

	/**
	 * @param args
	 * Concate String using space 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABCDE";
		appendSpace(s.toCharArray());
	}

	public static void appendSpace(char[]a) {
		int length = a.length;
		char[] newArray = new char[2*length-1];
		int space = length;
		for (int i = 0; i < 2*length-1; i++) {
			if(i<=length-1) {
				newArray[i] = a[i];
			} else {
				newArray[i] = 32;
			}
		}

		printArray(newArray);
		for (int i = length;i < (2*length-1); i++) {
			int tempSpace = space, j=i-1, tempi=i;
			while(tempSpace > 1) {
				// System.out.println(i + "," + j + "," + tempi + "," + space + "," + tempSpace);
				swap(newArray, tempi, j);
				printArray(newArray);
				j--;
				tempi--;
				tempSpace--;
			}
			space--;
		}
	}

	public static void swap(char[]a, int l, int r) {
		a[l] = (char) (a[l] ^ a[r]);
		a[r] = (char) (a[l] ^ a[r]);
		a[l] = (char) (a[l] ^ a[r]);
	}

	public static void printArray(char[]a) {
		for (char c:a) {
			System.out.print(c);
		}
		System.out.println();
	}

}
