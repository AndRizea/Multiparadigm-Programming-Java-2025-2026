package csie.ase.ro.classes;

public class Book {
	private String title;
	private int noPages;
	private int[] ratings;
	
	public enum Genre{
		SF, Drama, Comedy
	};
	
	private Genre genre;
	
	// another way of creating an enum
	// private GenreE genreE;

	public Book(String title, int noPages, int[] ratings, Genre genre) {
		this.title = title;
		this.noPages = noPages;
		this.ratings = ratings;
		this.genre = genre;
	}
	
	public Book() {
		this.title = "";
		this.noPages = 0;
		this.genre = Genre.SF;
		this.ratings = new int[1];
		this.ratings[0] = 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNoPages() {
		return noPages;
	}

	public void setNoPages(int noPages) {
		this.noPages = noPages;
	}

	public int[] getRatings() {
		int[] copy = new int[this.ratings.length];
		
		/*
		 * for(int i=0;i<copy.length;i++) { copy[i] = ratings[i]; }
		 */
		System.arraycopy(ratings, 0, copy, 0, ratings.length);
		
		return copy;
	}

	public void setRatings(int[] ratings) {
		this.ratings = new int[ratings.length];
		for(int i=0;i<this.ratings.length;i++) {
			this.ratings[i] = ratings[i];
		}
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public void showRatings() {
		for(int i =0; i< this.ratings.length; i++) {
			System.out.print(ratings[i] + " ");
		}
	}

	@Override
	public Object clone() /* throws CloneNotSupportedException */ {
		Book book = new Book();
		book.title = this.title;
		book.genre = this.genre;
		book.noPages = this.noPages;
		book.ratings = this.getRatings();
		
		return book;
	}
	
	
	
}
