package ch21.ex21_07;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListを内部で利用したスタッククラスです。
 * サブクラスにしても、内部で使用しても実装は可能でした。
 * 可読性は継承した方が高いです。サブクラスにして問題はないと思います。
 * @author Kyohei Mukai
 *
 */
public class StackContainedArrayList implements Stack{

	private ArrayList<Object> stack = null;

	StackContainedArrayList(){
		stack = new ArrayList<Object>();
	}

	public void push(Object e){
		stack.add(e);
	}

	public Object pop(){
		try{
			int clearIndex = stack.size()-1;
			Object popObject = stack.get(clearIndex);
			stack.remove(clearIndex);
			return popObject;
		}catch(IndexOutOfBoundsException e){
			throw new EmptyStackException();
		}
	}

	public Object peek(){
		try{
			return stack.get(stack.size()-1);
		}catch(IndexOutOfBoundsException e){
			throw new EmptyStackException();
		}
	}

	public boolean empty(){
		try{
			stack.get(0);
			return false;
		}catch(IndexOutOfBoundsException e){
			return true;
		}
	}

	public int search(Object e){
		for(int i=0; i<stack.size(); i++){
			if(stack.get(i).equals(e))
				return i+1;
		}
		return -1;
	}

}
