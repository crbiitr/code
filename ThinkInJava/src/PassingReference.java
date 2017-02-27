import java.io.*;
import java.util.*;
class Letter
{
	char c;
	Letter(){System.out.println("Chetan");}
}

public class PassingReference 
{
	static void f(Letter Y)
	{
		Y.c='Q';
	}
	
	static void swap(Letter X,Letter Y)
	{
		Letter Z=new Letter();
		Z.c=X.c;
		X.c=Y.c;
		Y.c=Z.c;
		
		
	}
	public static void main(String []args)
	{
		Letter X = new Letter();
		X.c='A';
		Letter Y= new Letter();
		Y.c='B';

		System.out.println("Before   " +X.c+ "   "+Y.c);
		swap(X,Y);
		System.out.println("After    " +X.c+ "   "+Y.c);

		System.out.println("X.c : "+X.c);
		f(X);
		System.out.println("X.c : "+X.c);
	}
}
