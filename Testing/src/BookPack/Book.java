package BookPack;

class testing {
	public String x1;
	protected String x2;
	private String x3;
	
	String getX1() {
		return x1;
	}
	void setX1(String x1) {
		this.x1 = x1;
	}
	String getX2() {
		return x2;
	}
	void setX2(String x2) {
		this.x2 = x2;
	}
	String getX3() {
		return x3;
	}
	void setX3(String x3) {
		this.x3 = x3;
	}
	
	
}

public class Book extends testing{

	protected String title;
	protected String author;
	protected int pubDate;
	public String reader;
	private String money;
	
	
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Book(String t, String a, int d) {
		title = t;
		author = a;
		pubDate = d;
	}
	
	public void show () {
		System.out.print(title + "    ");
		System.out.print(author + "    ");
		System.out.print(pubDate + "    ");
	}
	
}
