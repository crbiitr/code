package com.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		double values[] = {54.2,256.3,1450.78,5469.125,1.2};
		int i;
		double d;
		RandomAccessFile raf;
		long start = System.currentTimeMillis();
		long end;
		
		try {
			raf = new RandomAccessFile("/tmp/test3", "rw");
		} catch(FileNotFoundException e) {
			System.out.println("File Error");
			return;
		}
		
		for (int j = 0; j < values.length; j++) {
			try {
				raf.writeDouble(values[j]);
			} catch (IOException e) {
				System.out.println("Write Error");
				return;
			}
		}
		
		try {
			//reading values from file
			raf.seek(0);
			d = raf.readDouble();
			System.out.println("First Value is :: " + d);
			
			raf.seek(8);
			d = raf.readDouble();
			System.out.println("Second Value is :: " + d);
			
			raf.seek(8*3);
			d = raf.readDouble();
			System.out.println("Fourth Value is :: " + d);
			
			System.out.println();
			
			//reading all values;
			System.out.println("Reading all values");
			for(i = 0; i < values.length; i++) {
				raf.seek(8*i);
				System.out.print("   " + raf.readDouble());
			}
		} catch(IOException e) {
			System.out.println("Reading Error");
		}
		
		raf.close();
		end = System.currentTimeMillis();
		System.out.println("\nTotal Time Taken :: " +(end - start));
	}

}
