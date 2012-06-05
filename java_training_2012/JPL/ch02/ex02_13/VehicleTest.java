package ch02.ex02_13;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleTest {

	Vehicle v;

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
		v = new Vehicle(200, "Mukai", 20.0);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testGetSpeed() {
		assertEquals(v.getSpeed(), 200);
	}

	@Test
	public void testGetAngle() {
		assertEquals(v.getAngle(),20.0);
	}

	@Test
	public void testGetOwner() {
		assertNotNull(v.getOwner());
	}

	public void testGetIf(){
		assertNotNull(v.getId());
	}

}
