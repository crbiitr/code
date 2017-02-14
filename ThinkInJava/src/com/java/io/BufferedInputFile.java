package com.java.io;
import java.io.*;
public class BufferedInputFile {

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader (filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null) {
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		System.out.println(read("/home/user/bin/Hello.java"));
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time is :: " + (endTime-startTime) + " milliseconds");
	}
}
