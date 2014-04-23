package es2.bank.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import es2.bank.BankAccount;

public class BankAccountTest {
	
	/**
	 * 
	 * devo testare un BankAccount, 
	 * quindi creo un campo nella classe di test
	 */
	private BankAccount account = null;
	
	/* eseguito prima di ogni test */
	@Before
	public void setup(){
		this.account = new BankAccount();
	}
	
	@Test
	public void saldoContoAppenaCreato() {
		assertEquals("balance of a just created account is ", 
				new BigDecimal(0), this.account.balance());
	}
	
	@Test
	public void saldoDopoDeposito(){
		// manca deposit: devo aggiungere l'operazione
		this.account.deposit(new BigDecimal(10));
		
		// scenario particolare:
		// so quale e' il valore che mi aspetto
		assertEquals(new BigDecimal(10), this.account.balance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositoNullo(){
		account.deposit(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositoNegativo(){
		account.deposit(new BigDecimal(-10));
	}
	
	@Test
	public void dueDepositiConsecutivi(){
		account.deposit(new BigDecimal(10));
		account.deposit(new BigDecimal(15));
		assertEquals(new BigDecimal(25), account.balance());
	}
	
	@Test
	public void prelievoDaSaldoNullo(){
		account.withdraw(new BigDecimal(10));
		assertEquals(new BigDecimal(-10), account.balance());
	}
	
	@Test
	public void contoInRosso(){
		account.withdraw(new BigDecimal(10));
		assertTrue(account.isOverdraft());
	}
	
	@Test(expected = IllegalStateException.class)
	public void prelievoInRosso(){
		account.withdraw(new BigDecimal(10));
		account.withdraw(new BigDecimal(15));
	}
	
	@Test
	public void primaDepositoPoiPrelevo(){
		account.deposit(new BigDecimal(10));
		account.withdraw(new BigDecimal(5));
		assertEquals(new BigDecimal(5), account.balance());
	}

	
	@Test
	public void recuperaConto() {
		this.account.withdraw(new BigDecimal(10));
		this.account.deposit(new BigDecimal(15));
		assertFalse(this.account.isOverdraft());
	}
	
	@Test
	public void saldoDopoRecuperoDaContoInRosso(){
		this.account.withdraw(new BigDecimal(10));
		this.account.deposit(new BigDecimal(15));
		assertEquals(new BigDecimal(5), 	account.balance());
	}
}
