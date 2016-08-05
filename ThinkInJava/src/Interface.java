interface Pet
{
	public void test();
}
public class Interface implements Pet
{
	public void test()
	{
		System.out.println("Test method is define by Interface class");
	}
	public static void main(String []args)
	{
		Pet P = new Interface();
		P.test();
	}

}
