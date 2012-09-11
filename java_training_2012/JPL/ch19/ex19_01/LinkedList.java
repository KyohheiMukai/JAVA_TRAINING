package ch19.ex19_01;

/**
 * This class is a easy LinkedList.
 * @author Kyohei Mukai
 *
 */
public class LinkedList {

	private Object name;
	private LinkedList nextNode;

	/**
	 * It is this class's constructor.
	 * This constuctor's function is holding a object.
	 * It is used when argument object is final you want.
	 * @param name object
	 */
	LinkedList(Object name){
		this.name = name;
	}

	/**
	 * It is this class's constructor.
	 * This constuctor's function is holding a object and next node.
	 * It is used when you want argument object has next node.
	 * @param name object
	 * @param nextNode next object
	 */
	LinkedList(Object name, LinkedList nextNode){
		this(name);
		this.nextNode = nextNode;
	}

	/**
	 * return to object this class holding.
	 */
	public Object getName(){
		return name;
	}

	/**
	 * return to next node this class holding.
	 */
	public LinkedList getNextNode(){
		if(nextNode!=null)
			return nextNode;
		else
			return null;
	}

	/**
	 * return to length of this class having next node.
	 * If this class has no next node, return to zero.
	 */
	public int countList(){
		if(nextNode==null){
			return 0;
		}else{
			return 1+nextNode.countList();
		}
	}

}