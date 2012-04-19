package ch02.ex02_16;

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

	public Object getName(){
		return name;
	}

	public LinkedList getNextNode(){
		if(nextNode!=null)
			return nextNode;
		else
			return null;
	}

	/**
	 * 要素の数を返すメソッド
	 */
	public int countList(){
		if(nextNode==null){
			return 0;
		}else{
			return 1+nextNode.countList();
		}
	}

}
