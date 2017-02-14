package com.java.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteBinaryDataUsingDataIOStream {

	/**This program show how to read and write binary data using 
	 * DataInputStream and DataOutputStream
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		DataOutputStream dataout;
		DataInputStream datain;

		int i = 1;
		double d= 2.1;
		boolean b = true;

		try {
			dataout = new DataOutputStream(new FileOutputStream("/home/user/bin/DataInputOutputStreanTest.txt"));
			
		} catch (IOException e) {
			System.out.println("File Error, Can  not open file");
			return;
		}
		
		try {
			System.out.println("Writing " + i);
			dataout.writeInt(i);
			System.out.println("Writing " + d);
			dataout.writeDouble(d);
			System.out.println("Writing " + b);
			dataout.writeBoolean(b);
			System.out.println("Writing " + 258.35);
			dataout.writeDouble(258.35);
			
		} catch(IOException e) {
			System.out.println("Writing error");
		}
		
		dataout.close();
		
		try {
			datain = new DataInputStream(new FileInputStream("/home/user/bin/DataInputOutputStreanTest.txt"));
			
		} catch (IOException e) {
			System.out.println("File Error, Can  not open file");
			return;
		}
		
		try {

			i = datain.readInt();
			System.out.println("Readig " + i);
			d = datain.readDouble();
			System.out.println("Readig " + d);
			b = datain.readBoolean();
			System.out.println("Readig " + b);
			d = datain.readDouble();
			System.out.println("Readig " + 258.35);
		} catch(IOException e) {
			System.out.println("Read error");
		}		
		
		datain.close();
	}

	
}
