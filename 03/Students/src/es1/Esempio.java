package es1;
import java.util.Date;

/**
 * classe di esempio per mostrare 
 * la differenza tra tipi statici e dinamici
 * @author valerio
 *
 */
public class Esempio {
	public static void main(String[] args){
		// Il costruttore di Date e' deprecato, lo usiamo
		// solo per comodita' in questo esempio.
		Person bill = new Person("Bill", new Date(1955,10,28));
		Person pippo = new Student("Pippo", new Date(1930,05,02));		
		System.out.println(bill);
		System.out.println(pippo);
	}
}
