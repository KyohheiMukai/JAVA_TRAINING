package ch02.ex02_14;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch02.ex02_14.LinkedList;
import ch02.ex02_14.Vehicle;


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
	public void testGetName() {
		assertNotNull(list1.getName());
		assertNotNull(list2.getName());
	}

	@Test
	public void testGetNextNode() {
		assertNotNull(list1.getNextNode());
		assertNull(list2.getNextNode());
	}

}
