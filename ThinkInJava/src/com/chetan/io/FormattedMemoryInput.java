/*package com.chetan.io;
import java.io.*;
public class FormattedMemoryInput {
	public static final String filename = "/home/user/bin/Hello.java";
	public static void main(String[] args) throws IOException {
		
		try {
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(
							BufferedInputFile.read(filename).getBytes()));
			
			while(true) 
				System.out.println((char) in.readByte());
			
		} catch (EOFException E) {
			System.err.println("End of stream");
		}
	}
}
*/
package com.chetan.io;
import java.io.*;
public class FormattedMemoryInput {
	public static final String filename = "/home/user/bin/Hello.java";
	public static void main(String[] args) throws IOException {
		
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(filename)));
		
		while(in.available() != 0) 
			System.out.println((char) in.readByte());
	}
}