package ch06.ex06_05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ColorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testGetColor() {

		Color color = new Color(TrafficColor.BLUE);
		assertEquals(TrafficColor.BLUE, color.getColor());

		Color color2 = new Color(TrafficColor.RED);
		assertEquals(TrafficColor.RED, color2.getColor());

		Color color3 = new Color(TrafficColor.YELLOW);
		assertEquals(TrafficColor.YELLOW, color3.getColor());
	}

}
