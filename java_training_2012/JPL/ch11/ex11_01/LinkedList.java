package ch11.ex11_01;

public class LinkedList<E> implements LinkedListInterface{

	private Vehicle vehicle;
	private LinkedList<E> nextNode;

	public LinkedList(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public LinkedList(Vehicle vehicle,  LinkedList<E> nextNode){
		this(vehicle);
		this.nextNode = nextNode;
	}

	public String toString(Vehicle v){
		String strShow = "";
		strShow = "speed: "+v.speed;
		strShow += " angle: "+ v.angle;
		strShow += " owner: "+ v.owner;
		strShow += " id: "+ v.id;
		return strShow;
	}

	public Vehicle getVehicle(){
		return vehicle;
	}

	public LinkedList<E> getNextNode(){
		return nextNode;
	}

}
