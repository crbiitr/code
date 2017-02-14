package com.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	/**It is a first program of BufferedReader class
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the charecter and put . in the last  to Quit");
		
		do {
			c = (char)br.read();
			System.out.println(c);
		} while(c != '.');
	}

}
