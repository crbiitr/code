package com.chetan.io;
import java.io.*;
public class MemoryInput {
	public static final String filename = "/home/user/bin/Hello.java";
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		StringReader in = new StringReader(BufferedInputFile.read(filename));
		int c;
		while ((c=in.read()) != -1) {
			System.out.print((char)c );
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time is :: " +(endTime-startTime)+ "miliseconds");
	}

}
