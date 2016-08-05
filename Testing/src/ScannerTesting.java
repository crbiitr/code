import java.io.*;

public class ScannerTesting {

	public static void main(String []args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String [] Input = line.split(" ");
		
		int withdraw = Integer.parseInt(Input[0]);
		float balance = Float.parseFloat(Input[1]);
		System.out.print(withdraw + ",  " + balance);
		if(balance >=0 && balance <= 2000 && balance >=(withdraw +.5)) {
			if(withdraw%5==0) {
				balance -=(withdraw + .5);
			}
		}

		System.out.println(balance);
	}

}

