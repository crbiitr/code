package easypractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SUMTRIAN {

	public static void main(String[] args) throws IOException{
		System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NOTC = Integer.parseInt(br.readLine());
		int[] output = new int [1000];
		for(int i=0;i<NOTC;i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n][n];
			for(int j=0;j<n;j++) {
				String line = br.readLine();
				String[] rowInput = line.split(" ");
				for(int k=0;k<=j;k++) {
					a[j][k] = Integer.parseInt(rowInput[k]);
				}
			}
			output[i] = getMaxSum(a,n);
		}
		PrintArray(output,NOTC);

	}

	public static int getMaxSum(int a[][], int n) {
		for(int i=n-2;i>=0;i--) {
			for(int j=i;j>=0;j--) {
				if(a[i+1][j]>a[i+1][j+1]) 
					a[i][j]+=a[i+1][j];
				else
					a[i][j]+=a[i+1][j+1];
			}
		}
		return a[0][0];
	}
	
	public static void PrintArray(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}
}
