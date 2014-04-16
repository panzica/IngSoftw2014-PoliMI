package server;

import game.Game;
import game.Player;

import java.io.IOException;
import java.net.ServerSocket;

public class CFPServer {
	public void startServer(int port) throws IOException{
		ServerSocket listener;		
		listener = new ServerSocket(port);	
		System.out.println("CFPServer is running");
		
		try {
			while (true){				
				Player firstPlayer = new Player(listener.accept());				
				Player secondPlayer = new Player(listener.accept());
				Game game = new Game(firstPlayer, secondPlayer);
				game.startGame();				
			}			
		}finally {			
			listener.close();
		}
				
	}
	
	public static void main(String[] args){
		int port = 4001;
		CFPServer server = new CFPServer();
		
		try {
			server.startServer(port);			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
