import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by chetan on 7/3/17.
 * https://www.geeksforgeeks.org/number-possible-triangles-cartesian-coordinate-system/
 *https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
 */
public class Solution {

    static class Store implements Comparable<Store> {
        Character c;
        int count;

        public Store(Character c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return c+" --> "+count;
        }

        @Override
        public int compareTo(Store s1) {
            Store o1 = (Store) s1;
            return this.count-o1.count;
        }
    }

    public static final int steadyGene(String str) {
        if(str.length()==0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),map.get(str.charAt(i)) +1);
            } else {
                map.put(str.charAt(i),1);
            }
        }

        List<Store> list = new LinkedList<>();
        list.add(new Store('A',map.containsKey('A')?map.get('A'):0));
        list.add(new Store('C',map.containsKey('C')?map.get('C'):0));
        list.add(new Store('T',map.containsKey('T')?map.get('T'):0));
        list.add(new Store('G',map.containsKey('G')?map.get('G'):0));

        Collections.sort(list, Collections.<Store>reverseOrder());

        for (Store store: list) {
            System.out.println(store.toString());
        }


        int n = str.length();
        int count =0;
        while (!isCurrectString(list)) {
            if(list.get(0).count > list.get(list.size()-1).count) {
                count++;
                Store small = list.get(list.size()-1);
                Store big = list.get(0);
                int sCount = small.count; sCount++; small.count = sCount;
                int bCount = big.count; bCount--; big.count = bCount;

                list.remove(list.size()-1);
                list.remove(0);

                list.add(small);
                list.add(big);
                Collections.sort(list, Collections.<Store>reverseOrder());
            } else {
                return count;
            }
        }
        return count;
    }

    public static boolean isCurrectString(List<Store> list) {
        System.out.println("Calling isCurrectString()--->");
        if(list== null && list.size()==0) return true;
        boolean isValid = true;
        int pre = list.get(0).count;
        for (int i = 1; i <list.size() ; i++) {
            if(list.get(i).count!=pre) return false;
        }
        return isValid;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        String a = in.nextLine();
        System.out.println(steadyGene(a));
    }

}