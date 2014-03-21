package es02;

/*
 * Rappresenta un numero complesso.
 * Scelgo di implementare questa classe in modo che gli attributi
 * che la rappresentano non cambino mai (gli oggetti sono immutabili).
 * Nessun metodo cambia il valore degli attributi privati re, im.
 */
public final class Complex {

	/* parte reale */
	private final double re;
	/* parte immaginaria */
	private final double im;

	// Costruttore di default, costruisce lo zero
	public Complex() {
		// caso particolare del costruttore
		// con due parametri
		this(0.0d, 0.0d);
	}

	// Costruttore
	public Complex(double re, double im) {
		// ogni valore di re, im e' valido, non faccio
		// controlli di validita' sui parametri
		this.re = re;
		this.im = im;
	}

	// Non posso avere un costruttore con la stessa signature
	// di quello sopra.
	// public Complex(double modulus, double phase) {
	// re = ...;
	// im = ...;
	// }

	// uso un metodo di classe:
	/*
	 * Produce un numero complesso a partire dalla sua forma polare
	 */
	public static Complex fromPolarForm(double abs, double phase) {
		/* ricorda : z = modulus * (cos(phase) + i sin(phase)) */
		double realPart = abs * Math.cos(phase);
		double imaginaryPart = abs * Math.sin(phase);
		return new Complex(realPart, imaginaryPart);
	}

	// restituisce la parte reale del numero complesso
	public double re() {
		return this.re;
	}

	// restituisce la parte immaginaria del numero complesso
	public double im() {
		return im;
	}

	/*
	 * Restituisce il modulo (valore assoluto) del numero complesso.
	 */
	public double abs() {
		return Math.sqrt(Math.pow(this.re, 2.0d) + Math.pow(this.im, 2.0d));
	}

	/*
	 * Restituisce la fase (argomento) del numero complesso.
	 */
	public double phase() {
		// a bit of spaghetti code...
		if (this.re != 0) {
			double tmp = Math.atan(this.im / this.re);
			if (this.re < 0 && this.im >= 0)
				tmp += Math.PI;
			if (this.re < 0 && this.im < 0)
				tmp += -Math.PI;
			return tmp;
		} else { /* this.re == 0 */
			if (this.im < 0)
				return -Math.PI;
			/* if (this.im >= 0) (default) */
			return Math.PI;
		}
		// TODO: Cercate nella documentazione di java.lang.Math un modo per
		// implementare questo metodo in modo piu' conciso .
	}

	// restituisce il complesso coniugato di un numero.
	public Complex conjugate() {
		return new Complex(this.re, -this.im);
	}

	// restituisce la somma tra this e other.
	public Complex sum(Complex other) {
		return new Complex(this.re + other.re(), this.im + other.im());
	}

	// restituisce la differenza tra this e other
	public Complex diff(Complex other) {
		return new Complex(this.re - other.re(), this.im - other.im());
	}

	// restituisce il prodotto tra this e other
	public Complex mult(Complex other) {
		double productRe = this.re() * other.re() - this.im() * other.im();
		double productIm = this.re() * other.im() + this.im() * other.re();
		return new Complex(productRe, productIm);
	}

	// Uguaglianza approssimata, a meno di precision,
	// tra due numeri complessi
	public boolean approximatelyEquals(Complex other, double precision) {
		// controlla che la differenza in valore assoluto
		// tra i due numeri complessi sia minore di precision
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
	
	// Main di test.
	public static void main(String[] args) {
		// costruisco un complesso a partire da parte reale e immaginaria
		Complex a = new Complex(0.0, 1.0);
		// costruisco lo stesso complesso a partire dalla forma polare
		Complex b = Complex.fromPolarForm(1.0d, Math.PI / 2);

		// stampo i due complessi
		System.out.println(" a = " + a.re() + " + i * (" + a.im() + ")");
		System.out.println(" b = " + b.re() + " + i * (" + b.im() + ")");
		// controllo che a e b siano uguali a meno di un errore di 0.01
		System.out.print("a e b sono uguali a meno di 0.01 ? ");
		System.out.println(a.approximatelyEquals(b, 1e-2));
		
		
		int x = 5;
		int y = 5;
		System.out.println(x==y);
		
		Complex c1 = new Complex(0,0);
		Complex c2 = new Complex(0,0);
		System.out.println(c1==c2);

		
	}

	// TODO: Usando ComplexSet come implementato ad esercitazione
	// costruire un metodo che restituisca le radici di this di
	// grado "degree" (degree = 2 -> radici quadrate; degree = 3
	// -> radici cubiche).
	// ASSUMERE che degree sia > 0.
	// Se non si ricorda come calcolarle,
	// vedere
	// http://en.wikipedia.org/wiki/Complex_number#Multiplication.2C_division_and_exponentiation_in_polar_form
	public ComplexSet getRoots(int degree) {
		ComplexSet roots = new ComplexSet(1e-5);

		// inserire qui il resto dell'implementazione del metodo

		return roots;
	}
	
	

}
