package csie.ase.ro.main;

import csie.ase.ro.classes.Car;
import csie.ase.ro.classes.Vehicle;

public class Main {

	public static void main(String[] args) {
		
		// upcasting (implicit)
		Vehicle vehicle = new Car();
		vehicle.startEngine();
		
		// downcasting
		Vehicle carToBe = new Car();
		Car myCar = (Car) carToBe;
		myCar.honk();
		
		Car c = new Car();
		c.drive();

	}

}
