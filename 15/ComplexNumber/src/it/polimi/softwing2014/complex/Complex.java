package it.polimi.softwing2014.complex;

/**
 * Rappresenta un numero complesso.
 * Questa implementazione genera oggetti immutabili.
 * Non e' quindi possibile modificare 
 * la parte immaginaria e reale del numero. 
 * 
 * @author valerio
 * @version 1.0
 */
public class Complex {

	
	/**
	 * parte reale
	 */
	private final double re;
	/**
	 * parte immaginaria
	 */
	private final double im;

	/**
	 * Costruisce un numero complesso con valore (0,0).
	 */
	public Complex() {
		// caso particolare del costruttore con due parametri
		this(0.0d, 0.0d);
	}

	
	/**
	 * Costruisce un numero complesso dati ingresso la parte reale e immaginaria.
	 * @param re parte reale
	 * @param im parte immaginaria
	 */
	public Complex(double re, double im) {
		// ogni valore di re, im e' valido, non faccio
		// controlli di validita' sui parametri
		this.re = re;
		this.im = im;
	}

	
	/**
	 * Crea un numero complesso a partire dalla sua forma polare
	 * @param abs
	 * @param phase
	 * @return un nuovo numero complesso.
	 */
	public static Complex fromPolarForm(double abs, double phase) {
		/* ricorda : z = modulus * (cos(phase) + i sin(phase)) */
		double realPart = abs * Math.cos(phase);
		double imaginaryPart = abs * Math.sin(phase);
		return new Complex(realPart, imaginaryPart);
	}

	/**
	 * Restituisce la parte reale del numero complesso.
	 * @return La parte reale del numero complesso.
	 */
	public double re() {
		return this.re;
	}

	/**
	 * Restituisce la parte immaginaria del numero complesso.
	 * @return la parte immaginaria del numero complesso.
	 */
	public double im() {
		return im;
	}

	/**
	 * Restituisce il modulo (valore assoluto) del numero complesso.
	 * @return modulo del numero complesso.
	 */
	public double abs() {
		return Math.sqrt(Math.pow(this.re, 2.0d) + Math.pow(this.im, 2.0d));
	}


	/**
	 * Restituisce la fase (argomento) del numero complesso.
	 * @return la fase del numero complesso.
	 */
	public double phase() {
		return Math.atan2(im, re);
	}
	
	/**
	 * Crea il numero complesso coniugato del numero.  
	 * @return Un nuovo numero complesso che e' coniugato del numero.
	 */
	public Complex conjugate() {
		return new Complex(this.re, -this.im);
	}
	

	/**
	 * Crea un numero complesso somma di due numeri.
	 * @param other l'altro numero complesso da sommare.
	 * @return il numero complesso somma.
	 */
	public Complex sum(Complex other) {
		return new Complex(this.re + other.re(), this.im + other.im());
	}

	/**
	 * Crea un nuovo numero complesso differenza di due numeri.
	 * @param other l'altro operando
	 * @return il numero complesso differenza.
	 */
	public Complex diff(Complex other) {
		return new Complex(this.re - other.re(), this.im - other.im());
	}

	/**
	 * Crea un nuovo numero complesso prodotto di due numeri.
	 * @param other l'altro operando.
	 * @return il numero complesso prodotto.
	 */
	public Complex mult(Complex other) {
		double productRe = this.re() * other.re() - this.im() * other.im();
		double productIm = this.re() * other.im() + this.im() * other.re();
		return new Complex(productRe, productIm);
	}


	/**
	 * Uguaglianza approssimata, a meno di precision, di due numeri.
	 * L'uguaglianza approssimata controlla se la differenza in valore assoluto tra due 
	 * numeri complessi sia minore di una precisione passata come parametro. 
	 * @param other l'altro numero complesso da confrontare.
	 * @param precision la precisione del confronto di uguaglianza.
	 * @return {@code true} se la differenza e' minore di precision.
	 * 
	 * 
	 */
	public boolean approximatelyEquals(Complex other, double precision) {
		return (this.diff(other).abs() < precision);
	}


	@Override	
	public String toString() {
		return "Complex number: (" + re + ", " + im + ")";
	}


	@Override
	public boolean equals(Object other) {
		if (other instanceof Complex) {
			Complex otherComplex = (Complex) other;
			return this.im == otherComplex.im && this.re == otherComplex.re;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash * 23 + Double.valueOf(re).hashCode();
		hash = hash * 23 + Double.valueOf(im).hashCode();
		return hash;
	}
	
	


}
