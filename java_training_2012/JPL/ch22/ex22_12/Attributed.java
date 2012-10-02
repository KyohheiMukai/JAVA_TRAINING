package ch22.ex22_12;

import java.util.Iterator;

public interface Attributed{

	public void add(Attr newAttr);
	public Attr find(String name);
	public Attr remove(String name);
	public Iterator<Attr> iterator();
}
