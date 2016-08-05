package com.java.streepatternmatching;

public class WildCardCharacters {

	/**
	 * Its working properly
	 * @param args
	 */
	public static void main(String[] args) {
		match("g*ks".toCharArray(), "geeks".toCharArray()); // Yes
		match("ge?ks*".toCharArray(), "geeksforgeeks".toCharArray()); // Yes
		match("g*k".toCharArray(), "gee".toCharArray());  // No because 'k' is not in second
		match("*pqrs".toCharArray(), "pqrst".toCharArray()); // No because 't' is not in first
		match("abc*bcd".toCharArray(), "abcdhghgbcd".toCharArray()); // Yes
		match("abc*c?d".toCharArray(), "abcd".toCharArray()); // No because second must have 2 instances of 'c'
		match("*c*d".toCharArray(), "abcd".toCharArray()); // Yes
		match("*?c*d".toCharArray(), "abcd".toCharArray()); // Yes

	}

	/*	public static void test(char[]pat, char[]txt) {
		match(pat,txt)?System.out.println("YES"):System.out.println("NO");
	}*/

	public static void match(char[]pat, char[]txt) {
		int i,j;
		int M = pat.length;
		int N = txt.length;

		for ( i = 0; i <= N-M; i++) {
			int counter = 0;
			for ( j = 0; j < M; j++) {
				if ( pat[j] == '*') {
					if (j < M-1 && i+j+counter <= N-1) {
						if (txt[i+j+counter] != pat[j+1]) {
							counter++;
							j--;
						} else {
							j++;
							counter--;
						}
					} else {
						counter = N-i-j-1;
					}
				} else if (pat[j] == '?') {
					// j++;
					// counter = 0;
				} else {

					if (i+j+counter <= N-1 && txt[i+j+counter] != pat[j]) {
						break;
					}
				}
			}

			if (i + j + counter == N) {
				for (char c : pat) {
					System.out.print(c);
				}
				System.out.println(" Mached from position " + (i) + " to " + (i+j+counter));
			}			
		}
	}

}
