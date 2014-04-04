package Esecutori;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EsempioEsecutori {

	public static void main(String[] args) {
		ExecutorService esecutore = Executors.newFixedThreadPool(2);
		esecutore.submit(new TaskCheImpiegaTreSecondi("TaskA"));
		esecutore.submit(new TaskCheImpiegaTreSecondi("TaskB"));
		esecutore.submit(new TaskCheImpiegaTreSecondi("TaskC"));
		esecutore.shutdown();
	} 
}
class TaskCheImpiegaTreSecondi implements Runnable {
	private final String nome;
	public TaskCheImpiegaTreSecondi(String nome) {
		this.nome = nome;
	}
	public void run() {
		System.out.println(nome + " avviato alle: " + new Date());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		System.out.println(nome + " completato alle: " + new Date());
	} 

}
