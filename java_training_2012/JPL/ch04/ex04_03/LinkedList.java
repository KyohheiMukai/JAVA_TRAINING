package ch04.ex04_03;

public class LinkedList implements Cloneable,LinkedListInterface{

	private Vehicle vehicle;
	private LinkedList nextNode;

	public LinkedList(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public LinkedList(Vehicle vehicle, LinkedList nextNode){
		this(vehicle);
		this.nextNode = nextNode;
	}

	public LinkedList clone(){
		try{
			return (LinkedList)super.clone();
		}catch(CloneNotSupportedException e){
			throw new InternalError("CloneNotSupportedException");
		}
	}

	public String toString(Vehicle v){
		String strShow = "";
		strShow = "speed: "+v.speed;
		strShow += " angle: "+ v.angle;
		strShow += " owner: "+ v.owner;
		strShow += " id: "+ v.id;
		return strShow;
	}

	/**
	 * vehicleを返すように設計しているため、この設計ではインタフェースにするべきではない
	 * （というよりこの設計がよくない）
	 */
	public Vehicle getVehicle(){
		return vehicle;
	}

	public LinkedList getNextNode(){
		return nextNode;
	}

}
