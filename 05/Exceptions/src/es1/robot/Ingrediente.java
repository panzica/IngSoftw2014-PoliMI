package es1.robot;

public class Ingrediente {
	private String nome;
	private int quantita;
	
	public Ingrediente(String nome, int quantita){
		this.nome = nome;
		this.quantita = quantita;
	}
	
	@Override
	public boolean equals(Object o){		
		if (o instanceof Ingrediente){
			Ingrediente other = (Ingrediente)o;
			return nome.equals(other.nome);
		}
		else {
			return false;
		}
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getQuantita(){
		return quantita;
	}
	@Override	
	public int hashCode(){
		return nome.hashCode();		
	}
	

}
