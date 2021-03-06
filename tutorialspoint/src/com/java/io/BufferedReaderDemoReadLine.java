package com.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderDemoReadLine {

	/**Using readLine() method of BufferedReader class
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		Scanner scanner= new Scanner(System.in);

		int n = scanner.nextInt();
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the string and enter stop for quit the program");
		
		do {
			str = br.readLine();
			System.out.println(str);
		}while(!str.equals("stop"));
	}

}
