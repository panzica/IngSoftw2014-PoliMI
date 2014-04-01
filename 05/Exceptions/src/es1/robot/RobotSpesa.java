package es1.robot;

import java.util.Collection;

public class RobotSpesa extends Robot{
	
	public void spesa(Collection<Ingrediente> dispensa,
			Ingrediente ingredienteMancante){
		dispensa.add(ingredienteMancante);
		
	}
	

}
