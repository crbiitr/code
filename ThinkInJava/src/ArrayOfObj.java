import java.io.IOException;


class Demo
{
	int a;
	int b;
	public void setData(int c,int d)
	{
		a=c;
		b=d;
	}
	public void showData()
	{
		System.out.println("Value of a  "+a);
		System.out.println("Value of b  "+b);
	}

}
public class ArrayOfObj 
{
	public static void main(String []args) throws IOException
	{
		Demo x[]=new Demo[2];
		x[0].setData(1,2);
		x[1].setData(3,4);
		x[0].showData();
		x[1].showData();
	}
}
