package it.polimi.softwing2014.complex.client;

import it.polimi.softwing2014.complex.Complex;

public class SimpleClient {

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
		
	}

}
