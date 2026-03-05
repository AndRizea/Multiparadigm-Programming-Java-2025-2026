package csie.ase.ro.main;

import csie.ase.ro.classes.Book;
import csie.ase.ro.classes.Book.Genre;

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
		System.out.println();
		
		
		Book book3 = new Book("Book3", 350, new int[] {4,5,4}, Genre.SF);
		System.out.println("Average rating: " + book3.getAverageRating());
		
		
		// bi-dimensional array
		int noBooks = 2;
		int noRatings = 3;
		int[][] matrix = new int[][] {{2,3,4}, {4,5,6}};
		for (int i = 0; i < noBooks; i++) {
			for (int j = 0; j< noRatings ;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
