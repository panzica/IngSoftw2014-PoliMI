package factorymethod;

public class PizzaNapoletana extends Pizza{
	public PizzaNapoletana(){
		nome = "Margherita";
		impasto = "Spesso e Soffice";
		salsa = "della Nonna";
		ingredienti.add("Mozzarella di Bufala");
		ingredienti.add("Basilico Fresco");
	}
}
