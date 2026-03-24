package csie.ase.ro.classes;

import java.util.Objects;

public class Car implements Comparable<Car> {
	
	private String color;
	private int capacity;
	private String manufacturer;
	
	
	public Car(String color, int capacity, String manufacturer) {
		super();
		this.color = color;
		this.capacity = capacity;
		this.manufacturer = manufacturer;
	}
	
	public Car() {
		this.color = "white";
		this.capacity = 1000;
		this.manufacturer = "";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", capacity=" + capacity + ", manufacturer=" + manufacturer + "]";
	}

	@Override
	public int compareTo(Car o) {
		if(this.capacity < o.capacity) {
			return -1;
		} else if (this.capacity == o.capacity) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.manufacturer);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car c = (Car) obj;
			return manufacturer.equals(c.manufacturer);
		} else {
			return false;
		}
	}
	
	
	

}
