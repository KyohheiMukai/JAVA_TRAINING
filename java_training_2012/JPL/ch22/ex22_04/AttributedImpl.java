package ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedImpl extends Observable implements Attributed, Iterable<Attr>{

	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();

	@Override
	public void add(Attr newAttr) {
		attrTable.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	@Override
	public Attr find(String name) {
		return attrTable.get(name);
	}

	@Override
	public Attr remove(String name) {
		Attr removeObject = attrTable.remove(name);
		setChanged();
		notifyObservers(removeObject);
		return removeObject;
	}

	@Override
	public Iterator<Attr> iterator() {
		return attrTable.values().iterator();
	}

}
