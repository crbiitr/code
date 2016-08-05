package workspace.Utils.src;
import java.io.*;
public class Print {

	public static void println(Object obj) {
		System.out.println(obj);
	}
	public static void print() {
		System.out.println();
	}
	public static void print(Object obj) {
		System.out.print(obj);
	}
	public static PrintStream printf(String format, Object...args) {
		return System.out.printf(format , args);
	}
}
