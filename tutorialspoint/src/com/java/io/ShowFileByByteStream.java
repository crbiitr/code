package com.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFileByByteStream {

	/**
	 * show file contents using bytes stream
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		int i;
		FileInputStream fin;
		try {
		/*	File inputFile = new File("scjp.txt");
			File outputFile = new File("scjpcopy.txt");
			FileInputStream in = new FileInputStream(inputFile);
			FileOutputStream out = new FileOutputStream(outputFile);*/
			
//			fin = new FileInputStream(args[0]);
			fin = new FileInputStream("/home/user/bin/testGeoSenseStats.sh");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out Of Bound");
			return;
		}
		
		do {
			i = fin.read();
			if(i != -1) System.out.print((char)i);
		} while (i != -1);
		
		fin.close();
	}

}





