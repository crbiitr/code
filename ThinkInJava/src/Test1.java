class abc {
	public int x = 0;
	public abc(){
		//x=1;
	}
}

public class Test1 extends abc {
	public int y;
	abc ABC;
	public Test1(){
		y=2;
		
	}
	public static void main(String [] args) {
		Test1 test1 = new Test1();
		System.out.println(test1.y+"      "+test1.x);
	}
}
