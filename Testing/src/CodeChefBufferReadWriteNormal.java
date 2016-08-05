
//CodeChef submission 5215453 (JAVA) plaintext list. Status: AC, problem HS08TEST, contest . By super3bdo (super3bdo), 2014-10-25 19:38:54.
import java.io.*;

public class CodeChefBufferReadWriteNormal {

	public static void main(String[] args)throws IOException {

		String [] input;
		String buffer;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

		buffer=br.readLine();
		input=buffer.split(" ");
		double withdraw = Double.parseDouble(input[0]);
		double cerdit = Double.parseDouble(input[1]);
		if( (withdraw+0.5<=cerdit) && (withdraw%5==0)){
			double result=cerdit-withdraw-.5;
			System.out.print(result);
		}
		else{
			System.out.println(cerdit);
		}
	}

} 