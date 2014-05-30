package it.polimi.softwing2014.complex.set;

import it.polimi.softwing2014.complex.Complex;


public class ComplexSet {

	private final static int MAX_SIZE = 100;
	

	private final Complex[] elements;
	private int size;
	private final double precision;

	public ComplexSet() {
		this(2.0d * Double.MIN_VALUE);
	}

	public ComplexSet(double precision) {
		this.size = 0;
		this.elements = new Complex[MAX_SIZE];
		this.precision = precision;
	}

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

	public boolean contains(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return true;
		}		
		return false;
	}

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


	private int find(Complex element) {
		for (int i = 0; i < this.size; i++) {
			if (elements[i].approximatelyEquals(element, this.precision))
				return i;
		}
		/* default */
		return -1;
	}

	public int size() {
		return this.size;
	}

	public boolean isFull() {
		return size < MAX_SIZE;
	}

}
