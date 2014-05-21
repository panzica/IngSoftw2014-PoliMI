package factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	protected String nome;
	protected String impasto;
	protected String salsa;
	protected List<String> ingredienti = new ArrayList<>();
	

	public void prepara() {
		System.out.println("Preparazione di Pizza " + nome);
		System.out.println("Con l'impasto " + impasto);
		System.out.println("Aggiungi la salsa " + salsa);
		System.out.println("Aggiungi gli ingredienti:" );
		for (String ingrediente: ingredienti){
			System.out.println(ingrediente);
		}		
	}
	public void cuoci(){
		System.out.println("Cotta in forno per 10 minuti");
	}
	public void taglia(){
		System.out.println("Taglia la pizza a fette");
	}
	public void confeziona(){
		System.out.println("Metti la pizza nella scatola");		
	}
	public String getNome(){
		return nome;
	}

}
