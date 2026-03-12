package csie.ase.ro.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import csie.ase.ro.classes.Car;
import csie.ase.ro.classes.Vehicle;

public class Main {

	public static final int QUANTUM = 105;

	public static void main(String[] args) {

		// inheritance + upcasting & downcasting // upcasting (implicit)
		Vehicle vehicle = new Car();
		vehicle.startEngine();

		// downcasting
		Vehicle carToBe = new Car();
		Car myCar = (Car) carToBe;
		myCar.honk();

		// abstractization
		Car c = new Car();
		c.open(); // -> because it is a vehicle; all vehicles shall be able to be opened -> method implemented as abstract
		c.startEngine(); // -> main characteristic of a vehicle; inherited
		c.honk(); // -> main characteristic of a car
		c.drive(); // -> mandatory/required characteristic of a moveable car

		// polymorphism
		Car car = new Car("KIA", 5, "black", 2.1f);
		System.out.println(car);
		System.out.println("Tax computed based on engine capacity: " + car.computeTax(QUANTUM, car.getCapacity()));
		System.out.println("Tax computed based on number of seats: " + car.computeTax(QUANTUM, car.getNoSeats()));

		Car car2 = null;
		try {
			car2 = (Car) car.clone();
			car2.setColor("red");
			System.out.println(car2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// JCF - lists
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(7);

		System.out.println("First iteration");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("Second iteration");
		list.add(2, 8);
		for (Integer i : list) {
			System.out.println(i);
		}

		System.out.println("Third iteration");
		list.remove(0);
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

		Car car3 = new Car();
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		cars.add(car3);

		for (Car i : cars) {
			System.out.println(i);
		}

	}

}
