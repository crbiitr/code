import java.io.*;
import java.util.Locale;
import java.util.Calendar;

public class NumberInfo {

	public static void main(String []args)
	{
	int a = 9;
	float b = 84;
	long n=461012;
//static Integer decode(String s)	/*decode a string into in integer*/
//static int parseInt(String s)	    /*return an integer*/
//	Returns a String object representing the value of this Integer.
//	static Integer valueOf(int i)   /*Returns an Integer object holding the value of the specified primitive.*/
//compareTo(Integer anotherInteger)	/*compare number object to the argument*/
//intValue   						/*convert the number object into the primitive data type*/
//equals							/*compare the number object to the arguments*/	
	
//	The "valueOf" method converts a string to a number, and the "toString" method converts a number to a string.
	
	
	System.out.format("%d%n",n);
	System.out.format("%08d%n",n);
	System.out.format("%+8d%n",n);
	System.out.format("%,8d%n",n);
	System.out.format("%+,8d%n%n",n);
	
	double pi=Math.PI;
	
	System.out.format("%f%n",pi);
	System.out.format("%.3f%n",pi);
	System.out.format("%10.3f%n",pi);		
	System.out.format("%-10.3f%n",pi);
	System.out.format(Locale.FRANCE,"%-10.4f%n%n",pi);
	
	Calendar c=Calendar.getInstance();
	
	System.out.format("%tB %te %tY%n      %tD%n",c,c,c,c);
	
	System.out.println(Math.random());
	
	System.out.format("chetan %d,%n" +"raj",a,args);
	System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));
	
	String str="22";
	String s=str.toString();
	int x=Integer.valueOf(str);
	System.out.println(x+"   and  "+s);
	

	}
}