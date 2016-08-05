import java.io.*;

public class Main {

        public static void main (String [] args) throws IOException {
        	
        	long startTime = System.currentTimeMillis();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

            int noOfEntries = Integer.parseInt(in.readLine());
            
            for (int i = 1; i <= noOfEntries; i++) {
			}
            
            long endTime = System.currentTimeMillis();
            System.out.println("Total time is :: " + (endTime-startTime) + "milliseconds");
        }
}