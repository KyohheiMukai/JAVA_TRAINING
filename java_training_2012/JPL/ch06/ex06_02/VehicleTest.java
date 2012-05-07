package ch06.ex06_02;

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
		v_ = new Vehicle(200, "Mukai", 60.0);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testTurnDouble() {
		Vehicle v = new Vehicle(200, "Mukai", 20.0);
		v.turn(40.0);
		assertEquals(v_.getAngle(), v.getAngle());
	}

	@SuppressWarnings("deprecation")
	@Test
	/**
	 * enumを利用することにより、TURNの処理をVehicleクラスと分けることが可能となるため、
	 * 今後TURNに関する処理を追加したい際などに契約を明確にすることができる
	 */
	public void testTurnInt() {
		Vehicle v1 = new Vehicle(200, "Mukai", 150);
		v1.turn(Turn.TURN_LEFT);
		assertEquals(v_.getAngle(), v1.getAngle());

		Vehicle v2 = new Vehicle(200, "Mukai", -30.0);
		v2.turn(Turn.TURN_RIGHT);
		assertEquals(v_.getAngle(), v2.getAngle());
	}

}
