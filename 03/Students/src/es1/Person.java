package es1;

import java.util.Date;

public class Person {
	private final String name;
	private final Date birthday;
	public Person (String name, Date birthday){
		if (name == null || birthday == null)
			throw new IllegalArgumentException();
		this.name = name;
		// creo una copia dell'oggetto date per evitare che venga modificato dall'esterno
		this.birthday = new Date(birthday.getTime());		
	}
	
	public String getName(){
		return name;
	}
	// anche qui creo una copia per evitare modifiche esterne
	public Date getBirthday(){
		return new Date(birthday.getTime());
	}
	@Override
	public String toString(){
		return "My name is " + name;
	}

}
