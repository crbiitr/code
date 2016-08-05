package com.java.testing;

import java.util.Arrays;

public class Problem3 {

	public static void main(String[] args) {

		String dictionary[] = {"mobile","samsung","sam","man","mango",
				"icecream","and","i","like","ice","cream","gag","goo","gaga"};

		wordBreak("ilikesamsung",dictionary);
		System.out.println();
		wordBreak("gagagoogoo",dictionary);
		//wordBreak("iiiiiiii");
		//wordBreak("");
		wordBreak("ilikelikeimangoiii",dictionary);
		System.out.println();
		wordBreak("samsungandmango",dictionary);
		//cout<<"\n";
		wordBreak("samsungandmangok",dictionary);
		System.out.println();
	}

	static boolean dictionaryContains(String word,String dictionary[])
	{
		int size=dictionary.length;
		for (int i = 0; i < size; i++)
			if (dictionary[i].equals(word))
				return true;
		return false;
	}

	public static void wordBreak(String str1, String dictionary[])
	{
		char[] str = str1.toCharArray();
		int size = str1.length();

		int flag=0;
//		char prev[] = new char[1000];
//		char curr[] = new char[1000];
//		char temp[] = new char[1000];
//		int cind=0;
		StringBuilder curr1 = new StringBuilder();
		StringBuilder prev1 = new StringBuilder();
		StringBuilder temp1 = new StringBuilder();
		for (int i=0; i<size; i++)
		{   
//			curr[cind++]=str[i];
			curr1.append(str[i]);
			//curr[cind]='\0';


			if (flag==0 && dictionaryContains( curr1.toString(), dictionary) ) {
				prev1.setLength(0);
				prev1.append(curr1);
				temp1.setLength(0);
				temp1.append(curr1);
				curr1.setLength(0);
				flag=1; 
//				cind=0;
				continue;
			} 

			if (dictionaryContains((temp1.append(curr1)).toString(),dictionary) && !dictionaryContains(curr1.toString(),dictionary) ) {
				prev1.append(curr1);
				curr1.setLength(0);
//				cind=0;
			} else if(dictionaryContains(curr1.toString(),dictionary)) {
				System.out.print(prev1.toString() + " ");
				prev1.setLength(0);
				prev1.append(curr1);
				temp1.setLength(0);
				temp1.append(curr1);
//				prev1 = curr1;
//				temp1 = curr1;
//				System.arraycopy(curr, 0, prev, 0, curr.length);
//				System.arraycopy(curr, 0, temp, 0, curr.length);
//				cind=0;
				curr1.setLength(0);
			} 
//			System.arraycopy(prev, 0, temp, 0, prev.length);
			temp1.setLength(0);
			temp1.append(prev1);
		}

		if (dictionaryContains((temp1.append(curr1)).toString(),dictionary)) {
			System.out.print(temp1.toString() + " ");
		} else {
			System.out.println(prev1.toString() + " " + curr1.toString());
		}             

	}

	public static char[] concat(char[] a, char[] b) {
		int aLen = a.length;
		int bLen = b.length;
		char[] c= new char[aLen+bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}


}
