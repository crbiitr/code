import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestIp {

		    public static void main(String[] args) throws IOException {

		    	BufferedReader inputStream = null;
		        PrintWriter outputStream = null;
		        HashMap<String , String> mapper = new HashMap<String , String>();
		        try {
		            inputStream = new BufferedReader(new FileReader("/home/user/input.txt"));
		            outputStream = new PrintWriter(new FileWriter("/home/user/output.txt"));
		          
		            String l;
		             String [] split;
		            while ((l = inputStream.readLine()) != null) {
		            	split =l.split(" ");
		            	mapper.put(split[0],split[1]);
		                outputStream.println(l);
		                //System.out.println(l);
		            }
		           
		            System.out.println("   Key           Values");
		          int i = 1;
		            while(mapper.size()>i) {
//		            	System.out.println(mapper.get(key)+"     :     "+ mapper.values());
		            	i++;
		            }
//		            // Get a set of the entries
//		            Set set = mapper.entrySet();
//		            // Get an iterator
//		            Iterator i = set.iterator();
//		            // Display elements
//		            while(i.hasNext()) {
//		               Map.Entry me = (Map.Entry)i.next();
//		               System.out.print(me.getKey() + "    :    ");
//		               System.out.println(me.getValue());
//		            }
		            
		        } finally {
		            if (inputStream != null) {
		                inputStream.close();
		            }
		            if (outputStream != null) {
		                outputStream.close();
		            }
		        }
		    }
	    
	}