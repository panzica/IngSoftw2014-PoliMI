package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiEchoServer {
	private final int port;
	public MultiEchoServer(int port){
		this.port = port;
	}
	
	public void startServer() {
		ExecutorService executor = Executors.newCachedThreadPool();
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {			
			System.err.println("port not available " + e.getMessage());
			return;
		}
		System.out.println("Server ready");
		while (true){
			try {
				Socket socket = serverSocket.accept();
				executor.submit(new EchoServerClientHandler(socket));
			} catch(IOException e){
				break; // entrerei qui se serverSocket venisse chiuso
			}
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
	
	public static void main(String[] args){
		MultiEchoServer echoServer = new MultiEchoServer(4000);
		echoServer.startServer();
	}
	
	

}
