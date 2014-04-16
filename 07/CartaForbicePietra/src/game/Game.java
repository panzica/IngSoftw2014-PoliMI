package game;

import java.io.PrintWriter;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;
	
	public Game(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}
	public void startGame() {
		firstPlayer.setGame(this);
		secondPlayer.setGame(this);
		Thread t1 = new Thread(firstPlayer);
		t1.start();
		Thread t2 = new Thread(secondPlayer);
		t2.start();		
	}
	public synchronized void mossaCompiuta(){
		if (gameCompleted()){
			if (firstPlayer.getMossa().batte(secondPlayer.getMossa())){
				printWinningResult(firstPlayer.getOutput(), secondPlayer.getOutput());
			}
			else if (secondPlayer.getMossa().batte(firstPlayer.getMossa())){
				printWinningResult(secondPlayer.getOutput(), firstPlayer.getOutput());
			}
			else {
				// parita'
				printTie(firstPlayer.getOutput());
				printTie(secondPlayer.getOutput());
			}
			firstPlayer.closeConnections();
			secondPlayer.closeConnections();
		}
	}
	
	private void printWinningResult(PrintWriter winnerOutput, PrintWriter loserOutput){
		winnerOutput.println("Hai Vinto!!!");
		winnerOutput.flush();
		loserOutput.println("Hai perso :(");
		loserOutput.flush();
	}
	
	private void printTie(PrintWriter playerOutput){
		playerOutput.println("Parita'! ritenta");
		playerOutput.flush();
	}
	
	public boolean gameCompleted(){
		return firstPlayer.getMossa() != null && secondPlayer.getMossa() != null;
	}

}
