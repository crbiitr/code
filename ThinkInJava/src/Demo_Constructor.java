
public class Demo_Constructor 
{
	int value1;
	int value2;
	Demo_Constructor()
	{
		value1=1;
		value2=2;
		System.out.println("Inside the Parent constructor");
	}
	
	Demo_Constructor(int a)
	{
		value1=a;
		System.out.println("Inside the Parent Ist constructor");
	}
	
	Demo_Constructor(int a,int b)
	{
		value1=a;
		value2=b;
		System.out.println("Inside the Parent IInd constructor");
	}
	
	public void Display()
	{
		System.out.println("\nValue1  :  "+value1+"\nValue2   :  "+value2);
	}
	
	public static void main(String []args)
	{
		demo d=new demo();
		d.Display();
	}
}

class demo extends Demo_Constructor
{
	int value3;
	int value4;
	
	demo()
	{
		super(5,6);
		value3=3;
		value4=4;
		System.out.println("Inside the child constructor");
	}
	public void Display()
	{
		System.out.println("\nValue1  :  "+value1);
		System.out.println("Value2  :  "+value2);
		System.out.println("Value3  :  "+value3);
		System.out.println("Value4  :  "+value4);
	}
}
