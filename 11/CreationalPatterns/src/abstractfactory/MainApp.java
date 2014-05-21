package abstractfactory;

public class MainApp {
	public static void main(String[] args){
		Pizzeria bellaNapoli = new PizzeriaBellaNapoli();
		Pizzeria cinqueTerre = new PizzeriaCinqueTerre();
		
		Pizza pizza = bellaNapoli.ordinaPizza("margherita");
		System.out.println("Valerio ha ordinato la pizza " + pizza.getNome());
		System.out.println("###############");
		pizza = cinqueTerre.ordinaPizza("margherita");
		System.out.println("Carlo ha ordinato la pizza " + pizza.getNome());
	}

}
