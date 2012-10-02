package ch21.ex21_07;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListを継承したスタッククラス。
 * サブクラスにしても、内部で使用しても実装は可能でした。
 * 可読性はこちらの方が高いです。サブクラスにして問題はないと思います。
 * @author Kyohei Mukai
 *
 */
public class StackExtendsArrayList extends ArrayList<Object> implements Stack{

	private static final long serialVersionUID = 1L;

	public void push(Object e){
		add(e);
	}

	public Object pop(){
		try{
			int clearIndex = size()-1;
			Object popObject = get(clearIndex);
			remove(clearIndex);
			return popObject;
		}catch(IndexOutOfBoundsException e){
			throw new EmptyStackException();
		}
	}

	public Object peek(){
		try{
			return get(size()-1);
		}catch(IndexOutOfBoundsException e){
			throw new EmptyStackException();
		}
	}

	public boolean empty(){
		try{
			get(0);
			return false;
		}catch(IndexOutOfBoundsException e){
			return true;
		}
	}

	public int search(Object e){
		for(int i=0; i<size(); i++){
			if(get(i).equals(e))
				return i+1;
		}
		return -1;
	}

}
