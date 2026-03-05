package csie.ase.ro.classes;

import csie.ase.ro.classes.interfaces.Moveable;

public class Car extends Vehicle implements Moveable {
	
	private String color;
	private float capacity;
	
	
	public Car() {
		super();
		this.color = "white";
		this.capacity = 1.0f;
		System.out.println("Car default constructor");
	}
	
	
	public Car(String manufacturer, int noSeats, String color, float capacity) {
		super(manufacturer, noSeats);
		this.color = color;
		this.capacity = capacity;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public float getCapacity() {
		return capacity;
	}


	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	public void honk() {
		System.out.println("Car honks");
	}


	@Override
	public void open() {
		System.out.println("The car is opened");
		
	}


	@Override
	public void drive() {
		System.out.println("The car is moving below" + Moveable.MAX_SPEED + " km/h.");
		
	}

}
