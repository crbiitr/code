
class link {
	
	private int data1;
	private double data2;
	private link nextLink;
	
	public link(int d1, double d2) {
		data1 = d1;
		data2 = d2;
	}
	
	public void print() {
		
		System.out.println("{ " + data1 +" , " + data2 + " }");
	}
}

class LinkList{
	
	private link first;
	
	public LinkList () {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
}

public class MyList {

}
