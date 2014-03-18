package es06;

public class Cd implements Comparable<Cd>{
	private String titolo;
	private String autore;
	private float prezzo;
	private Giudizio giudizio;
	
	public Cd(String titolo, String autore, float prezzo, Giudizio giudizio){
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
		this.giudizio = giudizio;
	}
	
	@Override
	public String toString(){
		return "Autore: " + autore + " ," +
				"Titolo: " + titolo + " ," +
				"Prezzo: " + prezzo + " ," +
				"Giudizio: " + giudizio;
	}

	@Override
	public int compareTo(Cd other) {		
		return this.titolo.compareTo(other.titolo);
	}
}
