package com.java.searching;

/**
 * Question: 40
 * Page: 268
 * @param args
 */
public class RotationArray {

	public static void main(String[] args) {

		int array[] = {15,16,19,20,25,1,3,4,5,7,8,9,10,11,13,14};
		System.out.println("Size of array is : " + array.length);
		int index = Search(array, 9);
		if(index == -1) {
			System.out.println("Index is not present");
		} else {
			System.out.println("NO. found : " + array[index]);
		}
	}

	static int getPivote(int a[], int first, int last) {
		if(first == last) {
			return first;
		}
		else  if(first == last -1) {
			return a[first] >= a[last] ? first:last;
		}else {
			int mid = first + (last-first)/2;
			if(a[first] > a[mid]) 
				return getPivote(a, first, mid);
			else
				return getPivote(a, mid, last);
		}
	}

	static int Search(int a[], int data) {
		int pivote = getPivote(a, 0, a.length-1);
		System.out.println("Pivote is " + pivote);
		if(a[pivote] == data) return pivote;
		else if(a[pivote] < data) 
			return BinarySearchRecursion.BinarySearch(a, data, 0, pivote-1);
		else 
			return BinarySearchRecursion.BinarySearch(a, data, pivote+1, a.length-1);
	}
}
