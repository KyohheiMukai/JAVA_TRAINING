package ch02.ex02_16;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListTest {

	Vehicle v;
	Vehicle w;
	LinkedList list1;
	LinkedList list2;

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
		w = new Vehicle(250,"Shibata",30.0);

		list2 = new LinkedList(v);
		list1 = new LinkedList(w,list2);
	}

	@After
	public void tearDown() throws Exception {
		v = null;
		w = null;
		list1 = null;
		list2 = null;
	}

	@Test
	public void testCountList() {

		assertEquals(1, list1.countList());
		assertEquals(0, list2.countList());
	}

}
