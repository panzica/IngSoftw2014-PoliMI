package es2.bank;

import java.math.BigDecimal;

public class BankAccount {
	private BigDecimal balance;
	
	public BankAccount(){
		this.balance = new BigDecimal(0);
	}
	/**
	 * restituisce il saldo del conto.
	 */
	public BigDecimal balance() {
		// effettuo la modifica minima al
	    // codice per soddisfare il test.
	    // Non avendo la possibilita' di modificare
	    // lo stato del componente,
	    // il saldo non potra' che essere zero!
		return balance;
	}

	/**
	 * deposita una somma sul conto
	 */
	public void deposit(BigDecimal amount) {
		if (amount == null) 
			throw new IllegalArgumentException("amount cannot be null");
		if (amount.compareTo(new BigDecimal(0)) < 0) 
			throw new IllegalArgumentException("amount cannot be negative");
		balance = balance.add(amount);		
	}
	
	/**
	 * preleva dal conto
	 */
	public void withdraw(BigDecimal amount) {
		// TODO controlli su amount
		if (isOverdraft())
			throw new IllegalStateException("cannot withdraw under overdraft");
		balance = balance.subtract(amount);
	}
	
	/**
	 * verifica se il conto e' in rosso
	 */
	public boolean isOverdraft(){
		return balance.compareTo(new BigDecimal(0)) < 0;
	}

}
