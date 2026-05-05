package csie.ase.ro.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServerTCP {

	public static void main(String[] args) {
		int port = 8001;
		
		try(ServerSocket server = new ServerSocket(port)){
			System.out.println("Server connected on port" + port);
			
			Socket socket = server.accept();
			
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String receivedMessage = dataInputStream.readUTF();
			System.out.println("Message received: " + receivedMessage);
			
			// seding a message to the client
			OutputStream serverOutputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(serverOutputStream);
			dataOutputStream.writeUTF("Sensor data received");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
