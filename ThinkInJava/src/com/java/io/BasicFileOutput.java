package com.java.io;
import java.io.*;
public class BasicFileOutput {
	static String inputFilepath = "/tmp/Hello.java";
	static String outputFilepath = "/tmp/deleteme.txt";
    static String path;

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
        System.out.println(path==null);
//        BufferedWriter bw = new BufferedWriter(new FileWriter(path));



    }

}
