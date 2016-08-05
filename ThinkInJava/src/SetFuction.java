import java.util.*;

public class SetFuction 
{
	public static void main(String []args)
	{
		Random rand=new Random(47);
		Set<Integer> s=new HashSet<Integer>();
		for(int i=0;i<10000;i++)
			s.add(rand.nextInt(30));
		System.out.println(s);
	}
}
