package com.chetan.io;
import java.io.*;
public class BasicFileOutput {
	static String inputFilepath = "/home/user/bin/Hello.java";
	static String outputFilepath = "/home/user/bin/deletem.txt";
	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new StringReader(
					BufferedInputFile.read(inputFilepath)));
		
		PrintWriter out = new PrintWriter(
							new BufferedWriter(new FileWriter(outputFilepath)));
		
		int lineCount = 0;
		String s;
		while ( (s=in.readLine()) != null ) 
			out.println(++lineCount + "  :  " +s);
		out.close();
		System.out.println(BufferedInputFile.read(outputFilepath));
	}

}
