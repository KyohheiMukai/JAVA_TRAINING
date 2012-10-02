package ch21.ex21_05;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBenchList<E> implements ListIterator<E>{

	private final E[][] arrays;
	private final int size;
	private int array;
	private int off;
	private int pos;

	public ArrayBenchList(E[][] arrays){
		this.arrays = arrays.clone();
		int s = 0;
		for(E[] array : arrays)
			s += array.length;
		size = s;
		array = 0;
	}

	public int size(){
		return size;
	}

	@Override
	public boolean hasNext() {
		return off + pos < size();
	}

	@Override
	public E next() {
		if(!hasNext())
			throw new NoSuchElementException();
		E ret = arrays[array][pos++];

		while(pos >= arrays[array].length){
			off += arrays[array++].length;
			pos = 0;
			if(array >= arrays.length)
				break;
		}
		return ret;
	}

	@Override
	public boolean hasPrevious() {
		return pos >=  0;
	}

	@Override
	public E previous() {
		if(!hasPrevious())
			throw new NoSuchElementException();
		E ret = arrays[array][pos--];

		while(pos >= arrays[array].length){
			off += arrays[array--].length;
			pos = 0;
			if(array >= arrays.length)
				break;
		}
		return ret;
	}

	@Override
	public int nextIndex() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public E get(){
		return arrays[array][pos];
	}

	@Override
	public void set(E e) {
		arrays[array][pos] = e;
	}

	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();
	}

}