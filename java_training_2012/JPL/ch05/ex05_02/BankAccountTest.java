package ch05.ex05_02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {

	static BankAccount ba;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ba = new BankAccount();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testHistory(){
		for(int i=0; i<4; i++)
			ba.deposit(1000);
		for(int j=0; j<2; j++)
			ba.withdraw(1000);
		for(int k=0; k<5; k++)
			ba.deposit(1000);

		for(int l=0; l<10; l++)
			System.out.println(ba.history().next().toString());

	}

}
