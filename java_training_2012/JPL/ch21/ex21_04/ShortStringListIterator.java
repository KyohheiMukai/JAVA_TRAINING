package ch21.ex21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * ShortStringをListIteratorにて実装した別バージョン
 * @author Kyohei Mukai
 *
 */
public class ShortStringListIterator implements ListIterator<String>{

	/* ShortStringsクラスを拡張させたものを用いている、よって拡張すべきと考えられる*/

	private ListIterator<String> strings;
	private String previousShort;
	private String nextShort;
	private final int maxLength;

	public ShortStringListIterator(ListIterator<String> strings, int maxLength) {
		this.strings = strings;
		this.maxLength = maxLength;
		nextShort = null;
		previousShort = null;
	}

	@Override
	public boolean hasNext() {
		if(nextShort != null)
			return true;
		while(strings.hasNext()){
			nextShort = strings.next();
			if(nextShort.length() <= maxLength)
				return true;
		}
		nextShort = null;
		return false;
	}

	@Override
	public String next() {
		if(nextShort == null && !hasNext()){
			throw new NoSuchElementException();
		}
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public boolean hasPrevious() {
		if(previousShort != null)
			return true;
		while(strings.hasPrevious()){
			previousShort = strings.previous();
			if(previousShort.length() >= 0)
				return true;
		}
		previousShort = null;
		return false;
	}

	@Override
	public String previous() {
		if(previousShort == null && !hasPrevious()){
			throw new NoSuchElementException();
		}
		String n = previousShort;
		previousShort = null;
		return n;
	}

	@Override
	public int nextIndex() {
		return 0;
	}

	@Override
	public int previousIndex() {
		return 0;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(String e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(String e) {
		throw new UnsupportedOperationException();
	}

}
