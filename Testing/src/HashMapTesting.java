import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class HashMapTesting {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
/*


//		BufferedReader inputstream = new BufferedReader(new FileReader("/home/user/inputstream.txt"));
        PrintWriter outputstream = null;


        Map<String, Map<String, Long>> testMap = new HashMap<String, Map<String, Long>>();
        Map<String, Long> map = new HashMap<String, Long>();
        String superKey = null;
        String key = null;
        String value = "0";
        long increaseValue = 1;
        String option = "n";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		do {
        for (int i = 1; i < 11; i++) {
            System.out.println("Enter the super key : ");
            superKey = br.readLine();
            System.out.println("Enter the key : ");
            key = br.readLine();
            //	System.out.println("Enter the value for key : ");
            //	value = br.readLine();
            if (testMap.containsKey(superKey)) {
                if (testMap.get(superKey).containsKey(key)) {
                    testMap.get(superKey).put(key, testMap.get(superKey).get(key) + increaseValue);
                } else {
                    testMap.get(superKey).put(key, increaseValue);
                }
            } else {
                testMap.put(superKey, new HashMap<String, Long>());
                testMap.get(superKey).put(key, increaseValue);
            }
        }
//			System.out.println("Press com.java.Inheritance.y for continue and n for stop the program : ");
//			option = br.readLine();
//		} while (option.equals("com.java.Inheritance.y"));
        outputstream = new PrintWriter(new FileWriter("/home/user/outputstream.txt"));
        fileWrite(testMap, outputstream);
        outputstream.close();
//		printMap(testMap);

*/

    }
/*

	public static void printMap( Map<String , Map<String , Long>> mapper) {
		String l = "";
		Iterator itr = mapper.entrySet().iterator();
		while ( itr.hasNext() ) {
			Map.Entry pair = (Map.Entry) itr.next();
			l += (String) pair.getKey() +"\n";
			l += returnInnerMap((Map<String , Long>) pair.getValue());
			itr.remove();
			System.out.println(l);
			l="";
		}
	}
	public static String returnInnerMap( Map< String, Long> map) {
		String l = "";
		Iterator itr = map.entrySet().iterator();
		while ( itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			l += pair.getKey() + "\t" + pair.getValue() + "\n";
			itr.remove();
		}
		return l;
	}
	
	public static void fileWrite( Map<String, Map<String, Long>> mapper, PrintWriter outputstream) {
		
		String l = "";
		Iterator itr = mapper.entrySet().iterator();
		while ( itr.hasNext() ) {
			Map.Entry pair = (Map.Entry) itr.next();
			l += (String) pair.getKey() +"\n";
			l += returnInnerMap((Map<String , Long>) pair.getValue());
			itr.remove();
			outputstream.println(l);
			l="";
		}
	}



    */
}


