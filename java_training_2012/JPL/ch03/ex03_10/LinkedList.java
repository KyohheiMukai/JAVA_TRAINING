package ch03.ex03_10;

public class LinkedList implements Cloneable{

	private Vehicle vehicle;
	private LinkedList nextNode;

	public LinkedList(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public LinkedList(Vehicle vehicle, LinkedList nextNode){
		this(vehicle);
		this.nextNode = nextNode;
	}

	public LinkedList clone() throws CloneNotSupportedException{
		return (LinkedList)super.clone();
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

	public LinkedList getNextNode(){
		return nextNode;
	}

}
