package com.java.chetan.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileRreaderDemo {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("/tmp/test4");
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		fr.close();
	}

}
