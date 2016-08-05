package com.java.testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Problem2 {

	public static void main(String args[]) {

		int[] prices=new int[] {7,70,72,73,78,74,79,77};
//		int[] prices=new int[] {70,72,73,78,79,74,77};
		HashMap<Integer,Integer> buy_sell_days=new HashMap<Integer,Integer>();
		int buy_Day=0,sell_Day=0;
		int totalProfit=0;
		buy_sell_days.put(1, 1);
		buy_sell_days.put(2, 2);
		buy_sell_days.put(3, 3);
		buy_sell_days.put(4, 1);
		Iterator it = buy_sell_days.keySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair= (Map.Entry) it.next();
			 it.remove();
			
		}
		for(int i=0;i<prices.length;i++) {
			while(i<prices.length-1 && prices[i]>prices[i+1]) {
				i++;
			}
			buy_Day=i;
			while(i<prices.length-1 && prices[i]<prices[i+1]) {
				i++;
			}
			sell_Day=i;
			if(buy_Day!=sell_Day) {
				buy_sell_days.put(buy_Day,sell_Day);
			}
		}

		for(int key:buy_sell_days.keySet()) {
			int tempTotalProfit = 0;
			tempTotalProfit = (prices[buy_sell_days.get(key)]-prices[key]);
			if (tempTotalProfit > totalProfit) {
				totalProfit = tempTotalProfit;
				buy_Day = key;
				sell_Day = buy_sell_days.get(key);
			}
		}
//		System.out.println(buy_Day+""+sell_Day);
		int i = buy_Day+1, j = sell_Day+1;
		System.out.println(i + " " + prices[buy_Day] + "\n" + j + " " + prices[sell_Day]);
		cal(prices);
	}
	
	public static void cal(int prices[]) {
		int buy_Day=0,sell_Day=0;
		int totalProfit=0;
		int n = prices.length;
		for (int i=0;i<n-1;i++) {
			int diff =0;
			for (int j = i+1; j < n; j++) {
				diff = prices[j]-prices[i];
				
				if(totalProfit < diff) {
					buy_Day = i;
					sell_Day = j;
					totalProfit = diff;
				}
			}
		}
		
		System.out.println((buy_Day+1) + " " + prices[buy_Day] + "\n" + (sell_Day+1) + " " + prices[sell_Day]);
	}
	
}
