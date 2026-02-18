package csie.ase.ro;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from group 1049");
		
		Book newBook = new Book();
		
		Book comedy = new Book("Comedy", 250);
		
		System.out.println("Title: " + comedy.getTitle() +", No pages:" + comedy.getNoPages());
		
		// shallow copy
		Book comedyEdit = comedy;
		comedyEdit.setNoPages(400);
		
		System.out.println("Title: " + comedyEdit.getTitle() +", No pages:" + comedyEdit.getNoPages());
		System.out.println("Title: " + comedy.getTitle() +", No pages:" + comedy.getNoPages());
		
		// deep copy
		Book comedyDeepCopy = (Book) comedy.clone();
		comedyDeepCopy.setNoPages(600);
		System.out.println("============ output after cloning methods ==================");
		System.out.println("Title: " + comedyDeepCopy.getTitle() +", No pages:" + comedyDeepCopy.getNoPages());
		System.out.println("Title: " + comedyEdit.getTitle() +", No pages:" + comedyEdit.getNoPages());
		System.out.println("Title: " + comedy.getTitle() +", No pages:" + comedy.getNoPages());
		
	}

}
