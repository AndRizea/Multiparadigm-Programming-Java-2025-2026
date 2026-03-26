package csie.ase.ro.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private float average;

	public Student() {

	}

	public Student(String name, float average) {
		super();
		this.name = name;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", average=" + average + "]";
	}

	public void serialize() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("student.data");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(this);
		objectOutputStream.close();
	}

}
