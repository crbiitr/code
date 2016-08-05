import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSORT {

	final static int ARRAYSIZE = 1000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boundry = Integer.parseInt(br.readLine());
		int Array[] = new int[ARRAYSIZE];
		for(int i=1;i<=boundry;i++) {
			Array[Integer.parseInt(br.readLine())]=1;
		}
		
		for(int i=0;i<boundry;i++) {
			if(Array[i]==1) {
				System.out.println(i);
			}
		}
	}
}
