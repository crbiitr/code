import java.util.*;

public class Test9 {

	public  static void main(String []args) {
//        long starttime = System.currentTimeMillis();
        long starttime = System.nanoTime();
        String str = "kincenwinh";
        System.out.println(substringCalculator(str));
//        solve(str);
//        long endtime = System.currentTimeMillis();
        long endtime = System.nanoTime();

        test();

        System.out.println("Time : " + (endtime-starttime));
    }

    public static long substringCalculator(String st) {
//        ArrayList<String> set = new ArrayList<String>();
//        Set<String> set = new HashSet<String>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < st.length(); i++) {
            for (int j = 0; j < st.length() - i; j++) {
                String element = st.substring(j, j + (i + 1));
                if (!set.contains(element)) {
                    set.add(element);
                }
            }
        }
        return set.size();
    }


    public static void test() {
        HashMap<String,String > map = new HashMap<String, String>();

        map.put("123","abc");
        map.put("123","abc");
        map.put("123","xyz");

        for (String key: map.keySet()) {
            System.out.println(key  +"  :  "+ map.get(key));
        }
    }
}

