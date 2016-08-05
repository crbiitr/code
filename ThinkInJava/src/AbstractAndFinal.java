
abstract class Shape 
{
	final int b=20;
	public void display()
	{
		System.out.println("This is Display method");
	}
	
	abstract public void calculateArea();
}



public class AbstractAndFinal extends Shape
{
	public static void main(String []args)
	{
		AbstractAndFinal A = new AbstractAndFinal();
		A.display();
		//A.b=100;   //Error
		Test1 t  = new Test1();
		
	}
	public void calculateArea()
	{
		
	}
}
