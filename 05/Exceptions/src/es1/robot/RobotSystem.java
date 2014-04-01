package es1.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotSystem {
	public static void main(String[] args){
		RobotCuoco rCuoco = new RobotCuoco();
		RobotSpesa rSpesa = new RobotSpesa();
		RobotAssaggiatore rAssaggiatore = new RobotAssaggiatore();
		
		List<Ingrediente> dispensa=new ArrayList<Ingrediente>(); 
		dispensa.add(new Ingrediente("Sugo",1)); 
		dispensa.add(new Ingrediente("Basilico",1));
		dispensa.add(new Ingrediente("Sale",0));
		
		List<Ingrediente> ricetta=new ArrayList<Ingrediente>(); 
		ricetta.add(new Ingrediente("Sugo",2)); 
		ricetta.add(new Ingrediente("Basilico",1));
		ricetta.add(new Ingrediente("Sale",1));
		boolean piattoPronto = false;
		while (!piattoPronto){
				Piatto piatto= null;
			try {
				System.out.println("Cucino");
				 piatto = rCuoco.cucina(ricetta, dispensa);
			} catch (IngredienteMancanteException e) {
				
				rSpesa.spesa(dispensa, e.getIngr());			
			}
			finally{
				System.out.println("Comunque il latte serve sempre");
				rSpesa.spesa(dispensa, new Ingrediente("latte", 1));
			}
				piattoPronto = rAssaggiatore.assaggia(piatto);
		}
		
		System.out.println("Cotto e Mangiato");
	}

}
