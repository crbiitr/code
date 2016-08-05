
class x
{
	private int a;
	int b;
	public void m1()
	{
		System.out.println("This is method m1 of class x");
	}
}

class y extends x
{
	int c;
	public void m1()
	{
		System.out.println("This is method m1 of class y");
	}
	
	public void m2()
	{
		super.m1();
		System.out.println("This is method m2 of class y");
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
		
		//yy.a=10;
	}

}
