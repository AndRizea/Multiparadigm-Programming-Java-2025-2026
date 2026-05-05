package csie.ase.ro.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import csie.ase.ro.model.SensorData;

public class MainClientTCP {

	public static void main(String[] args) {
		SensorData sensor = new SensorData(56, 12.6f);

		try (Socket socket = new Socket("localhost", 8001)) {
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF(sensor.toString());

			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String messageReceived = dataInputStream.readUTF();
			System.out.println("Message received from the server: " + messageReceived);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
