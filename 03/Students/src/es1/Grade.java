package es1;

public class Grade {
	private final String subject; 	// La materia dell'esame
	private final int points;		// La valutazione ricevuta
	private final int credits;		// Il valore in crediti dell'esame

	public Grade(String subject, int points, int credits) {
		if (subject == null || points < 18 || points > 30 || credits < 0) {
			throw new IllegalArgumentException();
		}
		this.subject = subject;
		this.points = points;
		this.credits = credits;
	}

	public String getSubject() {
		return subject;
	}

	public int getPoints() {
		return points;
	}

	public int getCredits() {
		return credits;
	}

}