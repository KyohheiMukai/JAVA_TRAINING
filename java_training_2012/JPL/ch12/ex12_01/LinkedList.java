package ch12.ex12_01;

public class LinkedList implements LinkedListInterface{

	private Vehicle vehicle;
	private LinkedList nextNode;

	public LinkedList(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public LinkedList(Vehicle vehicle,  LinkedList nextNode){
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

	public LinkedList getNextNode(){
		return nextNode;
	}

	public Vehicle find(Vehicle v) throws ObjectNotFoundException{
		while(nextNode != null){
			if(v.equals(vehicle)){
				System.out.println(vehicle.owner +" is matched.");
				return vehicle;
			}else{
				vehicle = nextNode.vehicle;
			}
		}
		throw new ObjectNotFoundException();
	}
}