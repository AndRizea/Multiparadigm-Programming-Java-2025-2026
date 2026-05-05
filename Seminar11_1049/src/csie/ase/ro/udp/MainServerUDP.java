package csie.ase.ro.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MainServerUDP {

	public static void main(String[] args) {
		int port = 8000;

		try (DatagramSocket socket = new DatagramSocket(port)) {
			System.out.println("Server started on port: " + port);

			while (true) {
				byte[] buffer = new byte[256];

				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				String messageReceived = new String(packet.getData());
				System.out.println("Received meesage from the client: " + messageReceived);

				// respoding to the client
				String response = "Data received";
				byte[] bytes = response.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(bytes, bytes.length, packet.getAddress(),
						packet.getPort());
				socket.send(packetToSend);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
