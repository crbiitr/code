package com.java.chetan.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ComparingTwoFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		FileInputStream fin1;
		FileInputStream fin2;
		
		try {
			fin1 = new FileInputStream("/tmp/test1");
			fin2 = new FileInputStream("/tmp/test2");
			
		} catch(IOException e) {
			System.out.println("File Error");
			return;
		}
		
		int i = 0, j = 0;
		try {
			do {
				i = fin1.read();
				j = fin2.read();
				
				if(i != j) break;
			} while(i != -1 && j != -1);
			
		} catch(IOException e) {
			System.out.println("Read Error");
		}
		
		if(i != j) {
			System.out.println("Files are not same");
		} else {
			System.out.println("Files are same");
		}
		
		fin1.close();
		fin2.close();
		
	}

}
