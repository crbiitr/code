package com.java.chetan.io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		String str;
		FileWriter fw;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			fw = new FileWriter("/tmp/test4");
		} catch(IOException e) {
			System.out.println("ERROR: Can't open the file");
			return;
		}
		
		System.out.println("Enter text, write 'stop' for end");
		do {
			str = br.readLine();
			if(str.compareTo("stop") == 0) break;
			str = str + "\r\n"; //add new line
			fw.write(str);
		} while(!str.equals("stop"));
		fw.close();
	}

}
