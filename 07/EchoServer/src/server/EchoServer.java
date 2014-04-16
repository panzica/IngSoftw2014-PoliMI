package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	private final static int PORT = 4000;
	public void startServer() throws IOException{
		//apro una porta TCP
		ServerSocket serverScocket = new ServerSocket(PORT);
		System.out.println("Server socket ready on port: " + PORT);
		
		// resto in attesa di una connessione
		Socket socket = serverScocket.accept();
		System.out.println("received client connection");
		
		// apro gli stream di input e output per leggere
		// e scrivere nella connessione appena ricevuta
		Scanner in = new Scanner(socket.getInputStream());
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		// leggo e scrivo nella connessione finche' non ricevo "quit"
		while (true) {
			String line = in.nextLine();
			if (line.equals("quit")) {
				break;
			}
			else {
				out.println("Received: " + line);
				out.flush();
			}
		}
		
		System.out.println("Closing sockets");
		in.close();
		out.close();
		socket.close();
		serverScocket.close();
	}

	public static void main(String[] args){
		EchoServer echoServer = new EchoServer();		
		try {
			echoServer.startServer();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
