package BookPackB;
import BookPack.Book;


class ExtBook extends Book {
	
	private String publisher;
	
	public ExtBook(String t, String a, int d, String p) {
		super(t,a,d);
		publisher = p;
	}
	
	public void show() {
		super.show();
		System.out.println(publisher);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPubDate() {
		return pubDate;
	}

	public void setPubDate(int pubDate) {
		this.pubDate = pubDate;
	}

}



public class UseBook {

	public static void main(String args[]) {
		
		ExtBook books[] = new ExtBook[5];
		books[0] = new ExtBook("c++ ", "c1", 10, "chetan");
		books[1] = new ExtBook("c   ", "c2", 11, "Ratan");
		books[2] = new ExtBook("java", "c3", 12, "karan");
		books[3] = new ExtBook("c#  ", "c4", 13, "aman");
		books[4] = new ExtBook("php ", "c5", 14, "vipan");
		
		books[0].reader = "chetan";
//		books[0].x2 = "a";
		for(int i = 0; i < books.length ; i++) books[i].show();
		
		for(int i = 0; i < books.length ; i++)
			if(books[i].getAuthor() == "c4" )
				System.out.println("book title is :: "+ books[i].getTitle());
		
		
//		books[0].title  = "test title"; // Error – not accessible

	}
}
