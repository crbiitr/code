class A {
	
	void create() {
		System.out.println("Class A's create mathod called");
	}
}

class B extends A {
	
	void create() {
		System.out.println("Class B's create mathod called");
	}
}
public class Test9 {

	public static void main(String []args) {

		A b = new B();
		b.create();
	}
}
