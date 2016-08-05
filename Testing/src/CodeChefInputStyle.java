import static java.lang.Math.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class CodeChefInputStyle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//CodeChef submission 1964550 (JAVA) plaintext list. Status: AC, problem TABUS, contest . By fierro_oxidado (fierro_oxidado), 2013-03-25 02:22:13.


class BB {

	final static int MOD = (int)1e9 + 7;
	final static double eps = 1e-12;
	final static long INF = (long)1e6;

	@SuppressWarnings("unchecked")
	void solve () {
		int N = sc.nextInt();
		int T = sc.nextInt();
		int M = sc.nextInt();

		Integer [][] Z = sc.nextInts(M);

		SortedSet<Integer> [] A = new SortedSet [N];
		SortedSet<Long> [] D = new SortedSet [N];

		for (int i : rep(N)) {
			A[i] = new TreeSet<Integer>();
			D[i] = new TreeSet<Long>();
		}

		for (int i : rep(M)) {
			Integer [] F = Z[i];
			--F[0]; --F[1];
			int u = F[0], s = F[2], e = F[3];
			if (e <= T)
				D[u].add(INF * s + i);
		}

		boolean [] V = new boolean [M];
		PriorityQueue<Long> Q = new PriorityQueue<Long>(10);

		A[0].add(0); Long F = getFirst(D[0]);
		if (F != null)
			Q.add(F);

		int res = 0;

		while(!Q.isEmpty()) {
			Long G = Q.poll();
			assert(G >= 0);
			int w = (int)(G/INF), m = (int)(G%INF);
			if (V[m])
				continue;
			V[m] = true;
			res = max(res, w);
			Integer [] Y = Z[m];
			int u = Y[0], v = Y[1], s = Y[2], e = Y[3];
			if (v == N-1)
				exit(res);
			long a = A[u].headSet(s+1).last();
			D[u].remove(INF * s + m);
			Long J = getFirst(D[u], INF * s);
			if (J != null) {
				assert (J >= INF * a);
				Q.add(J - INF * a);
			}
			A[v].add(e);
			Long K = getFirst(D[v], INF * e);
			if (K != null) {
				assert (K >= INF * e);
				Q.add(K - INF * e);
			}
		}

		exit(-1);
	}

	<T> T getFirst(SortedSet<T> S) {
		return S.isEmpty() ? null : S.first();
	}

	<T> T getFirst(SortedSet<T> S, T F) {
		SortedSet<T> tail = S.tailSet(F);
		return tail.isEmpty() ? null : tail.first();
	}

	public static void init () {
	}

	////////////////////////////////////////////////////////////////////////////////////

	static int [] rep(int N) { return rep(0, N); }
	static int [] rep(int S, int T) { int [] res = new int [T-S]; for (int i = S; i < T; ++i) res[i-S] = i; return res; }
	static int [] req(int S, int T) { return rep(S, T+1); }

	////////////////////////////////////////////////////////////////////////////////////

	static MyScanner sc = new MyScanner();

	static class MyScanner {
		public String next() {
			readToken();
			return new String(b, T[0], T[1] - T[0]);
		}

		public char nextChar() {
			readToken();
			return (char)b[T[0]];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			readToken();
			return calc(T[0], T[1]);
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			readLine();
			return new String(b, T[0], T[1] - T[0]);
		}

		public String [] next(int N) {
			String [] res = new String [N];
			for (int i = 0; i < N; ++i)
				res[i] = next();
			return res;
		}

		public Integer [] nextInt(int N) {
			Integer [] res = new Integer [N];
			for (int i = 0; i < N; ++i)
				res[i] = nextInt();
			return res;
		}

		public Long [] nextLong(int N) {
			Long [] res = new Long [N];
			for (int i = 0; i < N; ++i)
				res[i] = nextLong();
			return res;
		}

		public Double [] nextDouble(int N) {
			Double [] res = new Double [N];
			for (int i = 0; i < N; ++i)
				res[i] = nextDouble();
			return res;
		}

		public String [] nextLine(int N) {
			String [] res = new String [N];
			for (int i = 0; i < N; ++i)
				res[i] = nextLine();
			return res;
		}

		public String [] nextStrings() {
			readLine();
			int s = T[0], c = 0;
			String [] res = new String[count(T[0], T[1])];
			for (int i = T[0]; i < T[1]; ++i)
				if (b[i] == SPACE) {
					res[c++] = new String(b, s, i - s);
					s = i+1;
				}
			res[c] = new String (b, s, T[1] - s);
			return res;
		}

		public char [] nextChars() {
			readToken();
			int c = 0;
			char [] res = new char[T[1] - T[0]];
			for (int i = T[0]; i < T[1]; ++i)
				res[c++] = (char)b[i];
			return res;
		}

		public Integer [] nextInts() {
			readLine();
			int s = T[0], c = 0;
			Integer [] res = new Integer[count(T[0], T[1])];
			for (int i = T[0]; i < T[1]; ++i)
				if (b[i] == SPACE) {
					res[c++] = (int)calc(s, i);
					s = i+1;
				}
			res[c] = (int)calc(s, T[1]);
			return res;
		}

		public Long [] nextLongs() {
			readLine();
			int s = T[0], c = 0;
			Long [] res = new Long[count(T[0], T[1])];
			for (int i = T[0]; i < T[1]; ++i)
				if (b[i] == SPACE) {
					res[c++] = calc(s, i);
					s = i+1;
				}
			res[c] = calc(s, T[1]);
			return res;
		}

		public Double [] nextDoubles() {
			readLine();
			int s = T[0], c = 0;
			Double [] res = new Double[count(T[0], T[1])];
			for (int i = T[0]; i < T[1]; ++i)
				if (b[i] == SPACE) {
					res[c++] = Double.parseDouble(new String(b, s, i - s));
					s = i+1;
				}
			res[c] = Double.parseDouble(new String(b, s, T[1] - s));
			return res;
		}

		String [][] nextStrings(int N) {
			String [][] res = new String [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextStrings();
			return res;
		}

		char [][] nextChars(int N) {
			char [][] res = new char [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextChars();
			return res;
		}

		Integer [][] nextInts(int N) {
			Integer [][] res = new Integer [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextInts();
			return res;
		}

		Long [][] nextLongs(int N) {
			Long [][] res = new Long [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextLongs();
			return res;
		}

		Double [][] nextDoubles(int N) {
			Double [][] res = new Double [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextDoubles();
			return res;
		}

		//////////////////////////////////////////////

		private final static int MAX_SZ = (int)1e7;
		private final byte [] b = new byte[MAX_SZ];
		private final int [] T = new int [2];
		private int cur = 0;

		MyScanner () {
			try {
				InputStream is = new BufferedInputStream(System.in);
				while (is.available() == 0)
					Thread.sleep(1);
				start();
				int off = 0, c;
				while ((c = is.read(b, off, MAX_SZ - off)) != -1)
					off += c;
			} catch (Exception e) {
				throw new Error(e);
			}
		}

		private void readLine() {
			int c;
			for (c = cur; b[c] != LF && b[c] != CR && b[c] != 0; ++c);
			T[0] = cur; T[1] = c;
			for (cur = c; b[cur] == LF || b[cur] == CR; ++cur);
		}

		private void readToken() {
			int c;
			for (c = cur; b[c] != SPACE && b[c] != LF && b[c] != CR && b[c] != 0; ++c);
			T[0] = cur; T[1] = c;
			for (cur = c; b[cur] == SPACE || b[cur] == LF || b[cur] == CR; ++cur);
		}

		private int count(int s, int e) {
			int cnt = 1;
			for (int i = s; i < e; ++i)
				if (b[i] == SPACE)
					++cnt;
			return cnt;
		}

		private long calc(int s, int e) {
			long res = 0, f = 1;
			for (int i = s; i < e; ++i)
				if (b[i] == '-')
					f = -1;
				else
					res = 10 * res + b[i] - '0';
			return res * f;
		}

		private static final char LF = '\n';
		private static final char CR = '\r';
		private static final char SPACE = ' ';
	}

	static void print (Object o, Object... a) {
		printDelim(" ", o, a);
	}

	static void cprint (Object o, Object... a) {
		printDelim("", o, a);
	}

	static void printDelim (String delim, Object o, Object... a) {
		pw.println(build(delim, o, a));
	}

	static void exit (Object o, Object... a) {
		print(o, a);
		exit();
	}

	static void exit () {
		pw.close();
		System.out.flush();
		Thread.yield();
		System.err.println("------------------");
		System.err.println("Time: " + ((millis() - t) / 1000.0));
		System.exit(0);
	}

	void NO() {
		throw new Error("NO!");
	}

	////////////////////////////////////////////////////////////////////////////////////

	static String build(String delim, Object o, Object... a) {
		StringBuilder b = new StringBuilder();
		append(b, o, delim);
		for (Object p : a)
			append(b, p, delim);
		return b.toString().trim();
	}

	static void append(StringBuilder b, Object o, String delim) {
		if (o.getClass().isArray()) {
			int L = Array.getLength(o);
			for (int i = 0; i < L; ++i)
				append(b, Array.get(o, i), delim);
		} else if (o instanceof Iterable<?>)
			for (Object p : (Iterable<?>)o)
				append(b, p, delim);
		else
			b.append(delim).append(o);
	}

	public static void test (byte [] input, PrintWriter output) {
		System.arraycopy(input, 0, sc.b, 0, input.length);
		sc.T[0] = sc.T[1] = 0; sc.cur = 0;
		pw = output;
		new BB().solve();
	}

	////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws IOException {
		init();
		int T = 1; // sc.nextInt();
		for (int t = 1; t <= T; ++t)
			new BB().solve();
		exit();
	}

	static void start() {
		t = millis();
	}

	public static PrintWriter pw = new PrintWriter(System.out);

	static long t;

	static long millis() {
		return System.currentTimeMillis();
	}
}
