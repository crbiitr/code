
import java.io.*;

public class BufferReaderWriterTesting2 {

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] input = line.split(" ");

		int limit = Integer.parseInt(input[0]); 
		int divider = Integer.parseInt(input[1]);
//		System.out.println(limit + ",  " + divider);

		for(int i = 1; i <= limit; i++) {
			if((line=br.readLine())!=null) {
				System.out.println(line);
			}
		}

	}

}
