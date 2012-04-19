package ch02.ex02_15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleTest {

	Vehicle v_;

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
		v_ = new Vehicle(200, "Mukai", 20.0);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testChangeSpeed() {
		Vehicle v = new Vehicle(300, "Mukai", 20.0);
		v.changeSpeed(200);
		assertEquals(v_.getSpeed(), v.getSpeed());
	}

	@Test
	public void testStop() {
		Vehicle v = new Vehicle(300, "Mukai", 20.0);
		v.stop();
		assertEquals(0, v.getSpeed());
	}

}
