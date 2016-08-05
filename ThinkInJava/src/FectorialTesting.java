import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FectorialTesting {
	static int len = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boundry = Integer.parseInt(br.readLine());
		for(int i=1;i<=boundry;i++) {
			len=0;
			printArray(getFectorial(Integer.parseInt(br.readLine())));
		}
	}
	
	static int[] getFectorial(int no) {
		int array[] = new int[200];
		array[0]=1;
		if(no==0 || no==1) return array;
		else {
			for(int i=no;i>=2;i--) {
				multiply(array, i);
			}
		}
		return array;
	}
	
	static void multiply(int [] array, int no) {
		int remain = 0;
		int modulo;
		int valOfLen = -1;
		for(int i=0;i<=len;i++) {
			int total = no*array[i];
			if((total+remain)<10) {
				array[i]=total+remain;
				remain=0;
			} else {
				total +=remain; 
				remain = total/10;
				modulo = total%10;
				array[i] = modulo;
			}
			valOfLen++;
		}
		len=valOfLen;
		while(remain>0) {
			modulo = remain%10;
			remain = remain/10;
			array[++len] = modulo; 
		}
	}
	
	static void printArray(int[]array) {
		
		for(int i=len;i>=0;i--) {
			System.out.print(array[i]);
		}
		System.out.println();
	}

}
