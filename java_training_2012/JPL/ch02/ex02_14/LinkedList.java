package ch02.ex02_14;

public class LinkedList {

	private Object name;
	private LinkedList nextNode;

	LinkedList(Object name){
		this.name = name;
	}

	LinkedList(Object name, LinkedList nextNode){
		this(name);
		this.nextNode = nextNode;
	}

	//変更を許可すべきではない
	public Object getName(){
		return name;
	}

	public LinkedList getNextNode(){
		if(nextNode!=null)
			return nextNode;
		else
			return null;
	}


}
