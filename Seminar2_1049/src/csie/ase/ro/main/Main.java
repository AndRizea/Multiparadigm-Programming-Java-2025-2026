package csie.ase.ro.main;

import csie.ase.ro.classes.Book;

public class Main {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		Book book2 = (Book) book1.clone();
		
		book2.setRatings(new int[] {1,2,3});
		
		book1.setTitle("Book1");
		book2.setTitle("Book2");
		
		book1.showRatings();
		System.out.println();
		book2.showRatings();
		

	}

}
