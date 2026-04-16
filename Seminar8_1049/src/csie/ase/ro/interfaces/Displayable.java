package csie.ase.ro.interfaces;

@FunctionalInterface
public interface Displayable {
	public void display();

	default public void display2(String message) {
		System.out.println(message);
	}

}
