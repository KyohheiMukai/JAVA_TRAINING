package ch10.ex10_03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckWorkIfElseTest {

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
	public void testIsWork() {
		CheckWorkIfElse c = new CheckWorkIfElse();
		assertTrue(c.isWork(Week.MONDAY));
		assertTrue(c.isWork(Week.TUESDAY));
		assertTrue(c.isWork(Week.WEDNESDAY));
		assertTrue(c.isWork(Week.THURSDAY));
		assertTrue(c.isWork(Week.FRIDAY));
		assertFalse(c.isWork(Week.SATURDAY));
		assertFalse(c.isWork(Week.SUNDAY));
	}

}
