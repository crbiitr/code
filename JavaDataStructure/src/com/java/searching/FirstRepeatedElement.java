package com.java.searching;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstRepeatedElement {

	public static void main(String[] args) {
		
		//		int array[] = {3,2,1,2,2,3}; // fail
		int array[] = {4,3,2,1,2,2,3};
		CheckFirstRepeted(array);

	}

	static void CheckFirstRepeted(int array[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				if(map.get(array[i]) > 0)
					map.put(array[i], map.get(array[i])*-1);
			} else {
				map.put(array[i], i);
			}
		}

		printMap(map);
		
		Map _map = SortHahsMapValueWise(map);
		System.out.println("After sorting : ");
		printMap(_map);
		
		int index = getIndex(_map);
		if(index != Integer.MIN_VALUE) {
			System.out.println("First repeated value is : " + array[index] + ", and index is : " + index);
		} else {
			System.out.println("No duplicate present");
		}
	}

	static Map SortHahsMapValueWise(HashMap map) {
		
		List list = new LinkedList(map.entrySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry)o1).getValue()).compareTo(((Map.Entry)o2).getValue());
			}
		});
		
		HashMap sortedHashMap = new LinkedHashMap();
		for(Iterator it=list.iterator(); it.hasNext();) {
			Map.Entry e = (Map.Entry)it.next();
			sortedHashMap.put(e.getKey(), e.getValue());
		}
		
		return sortedHashMap;
	}
	
	static int getIndex(Map map) {
		int index=Integer.MIN_VALUE;
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		while(it.hasNext()) {
			Entry<Integer, Integer> e = it.next();
			if(e.getValue() > index && e.getValue() < 0) {
				index = e.getValue();
			}
		}
		
		return Math.abs(index);
	}
	
	static void printMap(Map map) {

		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		while(it.hasNext()) {
			Entry<Integer, Integer> e = it.next();
			System.out.println("Key : " + e.getKey() + " ,  Value : " + e.getValue());
		}
	}
}
