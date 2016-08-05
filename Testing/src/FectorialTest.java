import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FectorialTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boundry = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=boundry;i++) {
			System.out.println(getFectorial(Long.parseLong(br.readLine())));
		}
		 

	}
	
	static long getFectorial(long no) {
		long fectorial = 1;
		
		if(no==0 || no==1) return fectorial;
		else {
			for(long i=no;i>=2;i--) {
				fectorial*=i;
			}
		}
		
		return fectorial;
	}

}
