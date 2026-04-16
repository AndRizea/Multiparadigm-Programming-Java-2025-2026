package csie.ase.ro.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import csie.ase.ro.classes.Student;

public class Main {

	public static void main(String[] args) {

		Student student = new Student("Maria", 9.7f);
		System.out.println(student);

		// writing into a text file
		try {
			FileOutputStream fos = new FileOutputStream("student.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(outputStreamWriter);

			bw.write(student.getName());
			bw.write(System.lineSeparator());
			bw.write(String.valueOf(student.getAverage()));

			bw.close();
			System.out.println("Student info written into student.txt");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading from a text file
		BufferedReader bufferedReader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("student.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader(inputStreamReader);

			Student s = new Student();
			s.setName(bufferedReader.readLine());
			s.setAverage(Float.parseFloat(bufferedReader.readLine()));
			System.out.println("Reading from a text file: " + s);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// writing into a binary file
		try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("student.bin"))) {
			dataOutputStream.writeUTF(student.getName());
			dataOutputStream.writeFloat(student.getAverage());
			System.out.println("Student info written into student.bin");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading from a binary file
		try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("student.bin"))) {
			Student s = new Student();
			s.setName(dataInputStream.readUTF());
			s.setAverage(dataInputStream.readFloat());

			System.out.println("Reading from a binary file: " + s);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// serialize an object
		try {
			student.serialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// deserialize an object
		Student deserializedStudent = new Student();
		try {
			deserializedStudent.deserialize();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Deserialized student: " + deserializedStudent);
		

	}

}
