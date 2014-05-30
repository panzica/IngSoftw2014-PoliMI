package it.polimi.softwing2014.complex;


public class Complex {

	
	private final double re;
	private final double im;

	public Complex() {
		// caso particolare del costruttore con due parametri
		this(0.0d, 0.0d);
	}
	
	public Complex(double re, double im) {
		// ogni valore di re, im e' valido, non faccio
		// controlli di validita' sui parametri
		this.re = re;
		this.im = im;
	}

	public static Complex fromPolarForm(double abs, double phase) {
		/* ricorda : z = modulus * (cos(phase) + i sin(phase)) */
		double realPart = abs * Math.cos(phase);
		double imaginaryPart = abs * Math.sin(phase);
		return new Complex(realPart, imaginaryPart);
	}

	public double re() {
		return this.re;
	}

	public double im() {
		return im;
	}

	public double abs() {
		return Math.sqrt(Math.pow(this.re, 2.0d) + Math.pow(this.im, 2.0d));
	}

	public double phase() {
		return Math.atan2(im, re);
	}
	
	public Complex conjugate() {
		return new Complex(this.re, -this.im);
	}

	public Complex sum(Complex other) {
		return new Complex(this.re + other.re(), this.im + other.im());
	}

	public Complex diff(Complex other) {
		return new Complex(this.re - other.re(), this.im - other.im());
	}

	public Complex mult(Complex other) {
		double productRe = this.re() * other.re() - this.im() * other.im();
		double productIm = this.re() * other.im() + this.im() * other.re();
		return new Complex(productRe, productIm);
	}

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
