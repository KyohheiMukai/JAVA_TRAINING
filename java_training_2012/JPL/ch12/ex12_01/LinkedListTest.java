package ch12.ex12_01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListTest {


	Vehicle car;

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
		car = new Vehicle("Mukai");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testLinkedList(){
		Vehicle car = new Vehicle("Mukai");
		car.speed = 100;
		car.angle = 45.0;

		Vehicle track = new Vehicle("Shibata");
		track.speed = 60;
		track.angle = 30.0;

		Vehicle spaceVehicle = new Vehicle("Noguchi");
		spaceVehicle.speed = 1000;

		Vehicle spaceVehicle2 = new Vehicle("Noguchi");
		spaceVehicle.speed = 1000;

		LinkedList list3 = new LinkedList(spaceVehicle);
		LinkedList list2 = new LinkedList(track,list3);
		LinkedList list1 = new LinkedList(car,list2);

		try {
			assertEquals(track, list1.find(track));

		} catch (ObjectNotFoundException e) {
		}

	}


}
