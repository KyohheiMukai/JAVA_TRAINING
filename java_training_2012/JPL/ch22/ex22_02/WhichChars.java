package ch22.ex22_02;

import java.util.HashSet;
import java.util.Iterator;

public class WhichChars {

	private  HashSet<Character> used = new HashSet<Character>();

	public WhichChars(String str) {
		for(int i=0; i<str.length(); i++)

			used.add(str.charAt(i));
	}

	public String toString(){
		String desc = "[";

		Iterator<Character> iterator = used.iterator();
		while(iterator.hasNext()){
			desc += iterator.next();
		}
//		for(int i= used.iterator(); i >= 0; i= used.nextSetBit(i+1))
//			desc += (char)i;
		return desc + "]";
	}

}
