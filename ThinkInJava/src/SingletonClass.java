
public class SingletonClass {

	public static final SingletonClass INSTENCE = new SingletonClass();
	
	private SingletonClass() {
		System.out.println("Chetan");
	}
	
	public void xx(){};
	
	
	
	public static void main(String []args) {
		SingletonClass A = new SingletonClass();
		SingletonClass A1 = new SingletonClass();

	}
}
