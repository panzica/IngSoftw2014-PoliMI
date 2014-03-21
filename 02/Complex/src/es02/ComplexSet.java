package es02;

/* Un insieme di dimensione massima FISSA
 * di numeri complessi distinti 
 * a meno di un dato errore.
 * Gli oggetti di questa classe
 * sono mutabili: lo stato dell'oggetto puo'
 * cambiare invocando i metodi add(Complex)
 * e remove(Complex).
 */
public class ComplexSet {

	// Rappresentazione interna: array di elementi
	private final Complex[] elements;
	// dimensione effettiva dell'insieme
	private int size;
	// precisione per controllare l'uguaglianza
	private final double precision;
	// costante che rappresenta la dimensione massima del set
	private final static int MAX_SIZE = 100;

	// costruttore di default, caso particolare
	// del costruttore che ha come argomento la
	// precisione.
	public ComplexSet() {
		this(2.0d * Double.MIN_VALUE);
	}

	// costruttore che prende come argomento
	// una precisione per il controllo dell'uguaglianza
	public ComplexSet(double precision) {
		this.size = 0;
		this.elements = new Complex[MAX_SIZE];
		this.precision = precision;
	}

	// Aggiunge un numero complesso all'insieme.
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

	// controlla che l'elemento sia contenuto nell'insieme
	public boolean contains(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return true;
		}
		/*
		 * // alternativa NON CORRETTA
		 * 
		 * for (Complex c: elements) { if (c.approximatelyEquals(element,
		 * this.precision)) return true; }
		 */

		/* default: non trovato */
		return false;
	}

	// rimuove un elemento dall'insieme.
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

	// metodo privato. restituisce la posizione
	// di un elemento nell'array se esiste (ed e'
	// entro this.size), -1 altrimenti
	private int find(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return i;
		}
		/* default */
		return -1;
		// Perche' non ha senso che questo metodo sia pubblico?
	}

	// TODO: (facile) scrivere contains(element) usando la find.

	// TODO: creare un metodo che restituisca un array
	// con SOLO gli elementi presenti nell'insieme,
	// di dimensione this.size
	public Complex[] toArray() {
		return null; // questa linea e' da commentare, ovviamente.
	}

	// restituisce la dimensione dell'insieme
	public int size() {
		return this.size;
	}

	public boolean isFull() {
		return size < MAX_SIZE;
	}

	/*
	 * TODO: rendere il set ancora bounded (cioe' con una dimensione massima) ma
	 * la dimensione massima puo' essere specificata nel costruttore.
	 * 
	 * TODO 2: rendere il set unbounded. Usare il metodo statico
	 * Arrays.copyOf(T[] original, int newLength). Importare Arrays dal package
	 * java.util
	 */
}
