package com.java.chetan.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFileByOutputStream {

	/**This program read the file using file input stream and 
	 * write that data on another file using file output stream
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		int i;
		FileInputStream fin;
		FileOutputStream fout;
		
		try {
			fin = new FileInputStream("/home/user/bin/testGeoSenseStats.sh");
		} catch(FileNotFoundException e) {
			System.out.println("File not found Exception for fin object");
			return;
		}
		
		try {
			fout = new FileOutputStream("/home/user/bin/testFileForFileOutputStream.txt");
			
			//Appending the file
//			fout = new FileOutputStream("/home/user/bin/testFileForFileOutputStream.txt",true);
		} catch(FileNotFoundException e) {
			System.out.println("File not found Exception for fin object");
			return;
		}
		
		//Copy File.
		try {
			do {
				i = fin.read();
				if(i != -1) fout.write(i); 
				
			}while(i != -1);
		} catch(IOException e) {
			System.out.println("File Error");
		}
		
		fin.close();
		fout.close();
	}

}
