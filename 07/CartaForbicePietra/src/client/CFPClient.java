package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CFPClient {
	public void startClient(int port) throws IOException{
		Socket socket = new Socket("127.0.0.1", port);
		System.out.println("Connection Established");
		Scanner socketIn = new Scanner(socket.getInputStream());
		PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
		Scanner stdin = new Scanner(System.in);
		while (socketIn.hasNextLine()){
			String socketLine = socketIn.nextLine();		
			if (socketLine.equals("WAITING"))
				break;
			System.out.println(socketLine);			
		}
		
		String inputLine = stdin.nextLine();
		socketOut.println(inputLine);
		socketOut.flush();
		
		while (socketIn.hasNextLine()){
			String socketLine = socketIn.nextLine();
			System.out.println(socketLine);		
		}
			
	
		socketIn.close();
		socketOut.close();
		stdin.close();
		socket.close();			
	
}

public static void main(String[] args){
	CFPClient client =  new CFPClient();
	try {
		client.startClient(4001);
	} catch (IOException e) {			
		e.printStackTrace();
	}
}

		


}
