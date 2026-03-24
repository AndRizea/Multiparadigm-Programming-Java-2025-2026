package csie.ase.ro.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import csie.ase.ro.classes.Car;

public class Main {

	public static void main(String[] args) {
		Car car1 = new Car("red", 2000, "Honda");
		Car car2 = new Car("black", 2500, "Ford");
		Car car3 = new Car("green", 2200, "Honda");
		
		List<Car> carList = new ArrayList<Car>();
		
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		
		System.out.println("List:");
		for(Car c : carList) {
			System.out.println(c);
		}
		
		System.out.println(carList);
		
		System.out.println("Set:");
		Set<Car> carSet = new TreeSet<Car>();
		carSet.add(car3);
		carSet.add(car2);
		carSet.add(car1);
		
		for(Car c : carSet) {
			System.out.println(c);
		}
		
		System.out.println("Map:");
		Map<Car, Integer> carMap = new HashMap<Car, Integer>();
		for (Car c: carSet) {
			if(!carMap.containsKey(c)) {
				carMap.put(c, 1);
			} else {
				Integer value = carMap.get(c);
				carMap.put(c, ++value);
			}
		}
		
		for(Map.Entry<Car, Integer> e : carMap.entrySet()) {
			System.out.print(e.getKey());
			System.out.print(" : ");
			System.out.println(e.getValue());
		}
		
		
		
	}

}
