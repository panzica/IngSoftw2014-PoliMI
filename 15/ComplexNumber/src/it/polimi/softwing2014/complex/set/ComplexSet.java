package it.polimi.softwing2014.complex.set;

import it.polimi.softwing2014.complex.Complex;

/* Un insieme di dimensione massima FISSA
 * di numeri complessi distinti 
 * a meno di un dato errore.
 * Gli oggetti di questa classe
 * sono mutabili: lo stato dell'oggetto puo'
 * cambiare invocando i metodi add(Complex)
 * e remove(Complex).
 */
/**
 * Un insieme di numeri complessi di dimensione massima <strong>fissa</strong>.
 * <p>Gli oggetti di questa classe sono mutabili: lo stato 
 * dell'oggetto puo' cambiare invocando i metodi {@code add} e {@code remove}
 * 
 * @author valerio
 * @version 1.0
 * @see Complex
 *
 */
public class ComplexSet {

	/**
	 * Dimensione massima dell'insieme.
	 */
	private final static int MAX_SIZE = 100;
	
	/** 
	 * Rappresentazione interna dell'insieme come array di Complex.
	 */
	private final Complex[] elements;
	
	/** 
	 * Dimensione corrente dell'insieme. 
	 */
	private int size;
		
	/**
	 * Precisione per il controllo dell'uguaglianza.
	 */
	private final double precision;
		

	
	/**
	 * Costruisce un insieme vuoto di numeri complessi con una precisione di default.  
	 */
	public ComplexSet() {
		this(2.0d * Double.MIN_VALUE);
	}

	
	/**
	 * Costruisce un insieme vuoto di numeri complessi con una specifica precisione.
	 * @param precision La precisione per identificare due numeri dell'insieme uguali.
	 */
	public ComplexSet(double precision) {
		this.size = 0;
		this.elements = new Complex[MAX_SIZE];
		this.precision = precision;
	}

	// Aggiunge un numero complesso all'insieme.
	/**
	 * Aggiunge un elemento all'insieme.
	 * @param element Il numero complesso da inserire all'insieme.
	 * @throws Exception Se l'insieme e' pieno.
	 */	
	public void add(Complex element) throws Exception {
		// invoco il metodo che controlla
		// la presenza dell'elemento nel set.
		boolean containsElement = this.contains(element);

		// se e' gia' presente non faccio nulla
		if (containsElement)
			return;

		/* controllo che il set non sia pieno */
		if (this.size < ComplexSet.MAX_SIZE) {
			this.elements[size] = element;
			this.size++;
		} else {
			throw new Exception("Set is full");
		}
	}

	
	/**
	 * Controlla se il numero complesso e' contenuto nell'insieme. 
	 * @param element
	 * @return <code>true</code> se l'elemento e' presente.
	 * @return <code>false</code> se l'elemento non e' presente.
	 */
	public boolean contains(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return true;
		}		
		return false;
	}

	/**
	 * Rimuove il numero complesso dall'insieme.
	 * @param element
	 */
	public void remove(Complex element) {
		// recupero l'elemento
		int pos = find(element);

		// shift elementi: evito di lasciare un buco
		// nell'array
		if (pos >= 0) {
			for (int i = pos; i < this.size - 1; i++)
				elements[i] = elements[i + 1];
			this.size = this.size - 1;
		}
	}

	
	/**
	 * Restituisce la posizione di un elemento nell'array se esiste.
	 * @param element numero complesso da cercare.
	 * @return la posizione del numero complesso nell'array
	 * @return -1 se l'elemento non e' presente.
	 */
	private int find(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return i;
		}
		/* default */
		return -1;
	}


	/**
	 * Restituisce la dimensione corrente dell'insieme.
	 * @return la dimensione dell'insieme.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Controlla se l'insieme e' pieno
	 * @return <code>true</code> se l'insieme e' pieno.
	 */
	public boolean isFull() {
		return size < MAX_SIZE;
	}


}
