/**
 * Reading bytes from Standard input
 */
package com.java.io;

import java.io.IOException;

/**
 * @author Chetan
 * 
 *
 */
public class ReadBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		byte data[] = new byte[10];
		System.out.println("Enter at most 10 character");
		System.in.read(data);
		System.out.println("You Entered : ");
		for (int i = 0; i < data.length; i++) {
			System.out.print((char)data[i]);
		}
	}

}
