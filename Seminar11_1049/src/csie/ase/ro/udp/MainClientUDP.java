package csie.ase.ro.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Random;

import csie.ase.ro.model.SensorData;

public class MainClientUDP {

	public static void main(String[] args) {
		SensorData sensor = new SensorData(60, 20.7f);

		try (DatagramSocket socket = new DatagramSocket()) {
			for (int i = 0; i < 5; i++) {
				Random random = new Random();
				int humidity = random.nextInt(100);
				float temp = random.nextFloat(45.0f);
				SensorData sensor2 = new SensorData(humidity, temp);

				String message = sensor2.toString();
				byte[] bytes = message.getBytes();
				DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"),
						8000);
				socket.send(packet);

				// receive message from server
				byte[] buffer = new byte[256];
				DatagramPacket packetToReceive = new DatagramPacket(buffer, buffer.length);
				socket.receive(packetToReceive);
				String messageReceived = new String(packetToReceive.getData());
				System.out.println("Message received from the server: " + messageReceived);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
