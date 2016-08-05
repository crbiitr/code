package com.java.searching;

public class Arranginga1a2a3b1b2b3 {

	public static void main(String[] args) {

		String[] array = {"a1","a2","a3","a4","a5","b1","b2","b3","b4","b5"};
		printArray(array);
		Alternate(array,0,array.length-1);
		printArray(array);
		

	}

	
	static void swap(String a[], int l, int r) {
		String temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}

	static void printArray(String a[]) {
		for(String i:a) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	static void Alternate(String []arr,int l,int h)

	{
		int low,high,m;
		if(l==h || l==h-1)
			return;
		else
		{
			m=((h+l)>>1)+1;
			if((((h-l+1)/2)%2) != 0)
			{
				high=m;
				low=l+1;
				while(low<m)
				{
					swap(arr,low,high);
					low++;high++;
				}
				Alternate(arr,l+1,h-1);
			}
			else
			{
				high=m;
				low=high-(h-m+1)/2;
				while(low<m)
				{
					swap(arr,low,high);
					low++;high++;
				}
				Alternate(arr,l,m-1);
				Alternate(arr,m,h);
			}
		}
	}

}
