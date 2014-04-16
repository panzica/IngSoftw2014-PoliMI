package game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player implements Runnable{
	private Socket socket;	
	private Mossa mossa;
	private Scanner input;
	private PrintWriter output;
	private Game game;
	
	public Player(Socket socket) {
		this.socket = socket;
		mossa = null;		
		try {
			input = new Scanner(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			output.println("Benvenuto! ");
			output.flush();
		} catch (IOException e) {			
			System.err.println("giocatore disconnesso");
		}				
	}
	
	public Mossa getMossa() {		
		return mossa;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public PrintWriter getOutput(){
		return output;
	}
	@Override
	public void run() {
		output.println("inserisci la tua mossa");
		output.println("WAITING");
		output.flush();
		String mossaString = input.nextLine();
		mossa = Mossa.valueOf(mossaString);
		game.mossaCompiuta();		
	}
	public void closeConnections(){
		input.close();
		output.close();
		try {
			socket.close();
		} catch (IOException e) {		
			System.err.println("Error closing socket");
		}
		
	}

}
