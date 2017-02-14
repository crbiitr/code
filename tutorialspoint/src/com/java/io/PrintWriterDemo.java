package com.java.io;

import java.io.PrintWriter;

public class PrintWriterDemo {

	/**This a program for explane how to use PrintWriter.
	 * In Real World program always use PrintWriter For output on console.
	 * @param args
	 */
	public static void main(String[] args) {

		PrintWriter pw = new PrintWriter(System.out, true);
		int i = 3;
		double d = 4.9;
		
		System.out.println("Using PrintWriter");
		pw.println(i);
		pw.println(d);
		
		pw.println(i + " + " + d + " = "+ (i + d));
	}
}
	
