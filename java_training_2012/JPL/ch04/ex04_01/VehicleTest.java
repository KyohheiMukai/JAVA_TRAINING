package ch04.ex04_01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testStart() {

		EnergySource gas1 = new GasTank(40.0);
		Vehicle v1 = new Vehicle(gas1);
		assertTrue(v1.start());

		EnergySource gas2 = new GasTank(0.0);
		Vehicle v2 = new Vehicle(gas2);
		assertFalse(v2.start());

		EnergySource battery1 = new Battery(100);
		Vehicle v3 = new Vehicle(battery1);
		assertTrue(v3.start());

		EnergySource battery2 = new Battery(0);
		Vehicle v4 = new Vehicle(battery2);
		assertFalse(v4.start());

	}

}
