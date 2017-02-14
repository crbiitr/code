package com.java.io;
import java.io.*;
public class FileOutputShortcut {

	static String inputFilepath = "/home/user/bin/awkTextfile.txt";
	static String outputFilepath = "/home/user/bin/deletem.txt";
	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new StringReader(
					BufferedInputFile.read(inputFilepath)));
		
		PrintWriter out = new PrintWriter(outputFilepath);
		
		int lineCount = 0;
		String s;
		while ( (s=in.readLine()) != null ) 
			out.println(++lineCount + "  :  " +s);
		out.close();
		System.out.println(BufferedInputFile.read(outputFilepath));
	}
}
