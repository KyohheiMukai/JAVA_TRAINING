package ch21.ex21_07;

import java.util.EmptyStackException;

import junit.framework.TestCase;

public class TestStack extends TestCase{

	Stack stack = null;
	String[] str = {"aaa","bbb"};
	public void setUp(){
		stack = new StackContainedArrayList();
//		stack = new StackExtendsArrayList();
	}

	public void test(){
		try{
			assertEquals("aaa", stack.pop().toString());
			fail();
		}catch(EmptyStackException e){

		}
		assertEquals(true, stack.empty());
		stack.push(str[0]);
		assertEquals("aaa", stack.peek());
		stack.push(str[1]);
		assertEquals("bbb", stack.peek());
		assertEquals(false, stack.empty());

		assertEquals(1, stack.search("aaa"));
		assertEquals(2, stack.search("bbb"));

		assertEquals("bbb", stack.pop().toString());
		assertEquals("aaa", stack.pop().toString());
		try{
			assertEquals("aaa", stack.pop().toString());
			fail();
		}catch(EmptyStackException e){

		}
		assertEquals(true, stack.empty());

	}

}
