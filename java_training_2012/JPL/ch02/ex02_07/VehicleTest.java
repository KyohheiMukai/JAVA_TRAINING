package ch02.ex02_07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SetupBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle();
	}

	@Test
	public void testVehicleString() {
		Vehicle v = new Vehicle("Mukai");
	}

	@Test
	public void testMain() {
		Vehicle.main(null);
	}

}
