package ch03.ex03_07;

public class ColorAttr extends Attr {

	private ScreenColor myColor;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name){
		this(name, "transport");
	}

	public ColorAttr(String name, ScreenColor value){
		super(name, value);
		myColor = value;
	}

	public Object setValue(Object newValue){
		Object retValue = super.setValue(newValue);
		decodeColor();
		return retValue;
	}

	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor(){
		return myColor;
	}

	/**
	 * 追加したメソッド
	 */

	public boolean equals(Object value){
		if(getValue().equals(value))
			return true;
		else
			return false;
	}

	public int hashCode(){
		return getValue().hashCode();
	}

	protected void decodeColor() {

		if(getColor()==null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

}
