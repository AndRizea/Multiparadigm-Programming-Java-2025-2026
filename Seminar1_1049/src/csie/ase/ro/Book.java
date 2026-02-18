package csie.ase.ro;

public class Book {
	
	String title;
	int noPages;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public int getNoPages() {
		return noPages;
	}

	public void setNoPages(int noPages) {
		this.noPages = noPages;
	}
	
	
	public Book() {
		this.title = new String("Title");
		this.noPages = 0;
	}

	public Book(String title, int noPages) {
		super();
		this.title = title;
		this.noPages = noPages;
	}

	@Override
	protected Object clone() {
		Book copy = new Book();
		copy.title = new String(this.title);
		copy.noPages = this.noPages;
		return copy;
	}
	
	

}
