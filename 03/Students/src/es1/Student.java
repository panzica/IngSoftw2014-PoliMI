package es1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person{
	private final List<Grade> grades; 
	
	public Student (String name, Date birthday){
		super(name,birthday);		
		grades = new ArrayList<Grade>();
	}

	
	// Aggiunge una valutazione alla carriera dello studente.
	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	// Controlla se lo studente ha abbastanza crediti per potersi laureare.
	public boolean canGraduate() {
		return totalCredits() >= 180;
	}

	// Calcola la media pesata.
	public double getWeightedGradeAverage() {
		double sumOfWeightedPoints = 0;
		for (Grade grade : grades) {
			sumOfWeightedPoints += grade.getCredits() * grade.getPoints();
		}
		return sumOfWeightedPoints / totalCredits();
	}

	// Calcola il numero di crediti sostenuti dallo studente.
	private int totalCredits() {
		int totalCredits = 0;
		for (Grade grade : grades) {
			totalCredits += grade.getCredits();
		}
		return totalCredits;
	}

	@Override
	public String toString() {
		return super.toString() + " and I am a student";
	}



}
