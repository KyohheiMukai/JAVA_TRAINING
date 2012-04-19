package ch02.ex02_08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListTest {


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

	/**
	 * すみません。
	 * テストコード書くのが初めてで、
	 * どう書いたらよいかわかりませんでした。
	 */
	@Test
	public void testLinkedListObject() {

	}

	@Test
	public void testLinkedListObjectLinkedList() {

	}

}
