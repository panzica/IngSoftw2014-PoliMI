package abstractfactory;


public abstract class Pizza {
	protected String nome;
	protected Impasto impasto;
	protected Salsa salsa;
	protected Formaggio formaggio;
	
	
	
	PizzaIngredientFactory ingredientFactory;
	public Pizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory = ingredientFactory;
	}
	public abstract void prepara();
	
	public void cuoci(){
		System.out.println("Cotta in forno per 10 minuti");
	}
	public void taglia(){
		System.out.println("Taglia la pizza a fette");
	}
	public void confeziona(){
		System.out.println("Metti la pizza nella scatola");		
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	
	

}
