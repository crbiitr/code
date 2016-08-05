import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class PalindromDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababckjkksajk";
		if(canConvertIntoPalindrom(s)) {
			System.out.println("Possible");
		} else {
			System.out.println("Not Possible");
		}
		

	}
	
	static boolean canConvertIntoPalindrom(String s) {
		
		boolean flag = true;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for( char x : s.toCharArray()) {
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1);
			}else {
				map.put(x, 1);
			}
		}
		
		int isOnce = 0;
		Set<Map.Entry<Character,Integer>> set = map.entrySet();
		
		for(Entry<Character,Integer> e: set) {
			System.out.print("   " + e.getKey().toString());
			if(((e.getValue())%2)==1 && isOnce==1) {
				flag = false;
				break;
			} else if(((e.getValue())%2)==1 && isOnce==0){
				isOnce=1;
			}
		}
		
		return flag;
	}

}
