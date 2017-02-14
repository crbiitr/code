package com.java.Inheritance;

class x
{
	private int a;
    protected int b;
	int c;
	public void m1()
	{
		System.out.println("This is method m1 of class com.java.Inheritance.x");
	}
}

class y extends x
{
	int d;
	public void m1()
	{
		System.out.println("This is method m1 of class com.java.Inheritance.y");
	}

/*
    public void m1()
    {
        super.m1();
        System.out.println("This is method m1 of class com.java.Inheritance.y");
    }
*/


    public void m2()
	{
		super.m1();
		System.out.println("This is method m2 of class com.java.Inheritance.y");
	}

}

public class Inheritence 
{
	public static void main(String [] args)
	{
		x xx = new x();
		y yy = new y();
		
		xx.m1();
		yy.m1();
		yy.m2();
		
		xx=yy;
		
		xx.m1();
		yy.m1();
		yy.m2();
		
//		yy.a=10;
        yy.b = 10;

        x xxx = new y();
        xxx.m1();

//        Not possible
//        com.java.Inheritance.y yyy = new com.java.Inheritance.x();
	}

}
