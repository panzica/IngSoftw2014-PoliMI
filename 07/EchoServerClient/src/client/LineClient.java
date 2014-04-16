package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LineClient {
	private final static int PORT = 4000; 
	public void startClient() throws IOException {
		Socket socket = new Socket("127.0.0.1", PORT);
		System.out.println("Connection Established");
		Scanner socketIn = new Scanner(socket.getInputStream());
		PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
		Scanner stdin = new Scanner(System.in);		
		
			while (true) {
				String inputLine = stdin.nextLine();
				socketOut.println(inputLine);
				socketOut.flush();
				if (socketIn.hasNextLine()){
					String socketLine = socketIn.nextLine();
					System.out.println(socketLine);
				}
				else {
					break;
				}				
			}	
		
			socketIn.close();
			socketOut.close();
			stdin.close();
			socket.close();			
		
	}
	
	public static void main(String[] args){
		LineClient client =  new LineClient();
		try {
			client.startClient();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
