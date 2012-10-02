package ch22.ex22_04;

import java.util.Observable;
import java.util.Observer;

public class AttributedObserver implements Observer{

	private AttributedImpl attributed = null;

	AttributedObserver(AttributedImpl attributed){
		this.attributed = attributed;
		attributed.addObserver(this);
	}

	@Override
	public void update(Observable attributed, Object attr) {
		if(this.attributed != attributed)
			throw new IllegalArgumentException();

		if(this.attributed.attrTable.containsValue(attr))
			System.out.println("add in Attributed");
		else
			System.out.println("remove in Attributed.");
	}

}
