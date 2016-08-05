package com.java.streepatternmatching;

/**
 * @author user
 * Robin Karp Algo for String pattern matching 
 */
public class RobinKarp {

	public static final int d = 256;
	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		int prime = 101;
		patternMatch(txt.toCharArray(), pat.toCharArray(), prime);

	}

	public static void patternMatch(char[] txt, char[]pat, int prime) {
		int i,j;
		int p = 0;
		int t = 0;
		int h = 1;
		int M = pat.length;
		int N = txt.length;

		for(i = 0; i < M-1; i++) {
			h = (h*d)%prime;
		}

		for(i = 0; i < M; i++) {
			p = (p*d + pat[i])%prime;
			t = (t*d + txt[i])%prime;
		}

		for(i = 0; i <= N-M; i++) {
			System.out.println(i);
			if(p == t) {
				for(j = 0; j < M; j++) {
					if(txt[i+j] != pat[j]) {
						break;
					}
				}

				if(j == M) {
					System.out.println("Pattern Mached from index : " + i);
				}
			}
			if(i < N-M) {
				t = (d * (t - txt[i]*h) + txt[i+M])%prime;
				if(t<0) {
					t = t + prime;
				}
			}
		}
	}

}
