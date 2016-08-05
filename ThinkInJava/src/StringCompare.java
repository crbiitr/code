
public class StringCompare 
{
	StringCompare(){System.out.println("chetan");}
	StringCompare sc=new StringCompare();
	public static void main(String []args)
	{
		String a=new String("abcd");
		String b=new String("abcd");
		
		if(a==b)
		{
			System.out.println("==");
		}
		else
			System.out.println("!=");
	}
}
