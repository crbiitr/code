import java.io.*;
import java.util.*;

public class RandomFunvtion 
{
	public static void main(String []args)
	{
		Random rand = new Random(47);
		int i, j, k;
		// Choose value from 1 to 100:
		j = rand.nextInt(100) + 1;
		System.out.println("j : " + j);
		k = rand.nextInt(100) + 1;
		System.out.println("k : " + k);

	}

}
