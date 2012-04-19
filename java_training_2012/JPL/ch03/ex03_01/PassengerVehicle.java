package ch03.ex03_01;

public class PassengerVehicle extends Vehicle {

	private int capacity;
	private int passenger;

	PassengerVehicle(int speed, String ownerName, double angle, int capacity, int passenger){
		super(speed, ownerName, angle);
		this.capacity = capacity;
		this.passenger = passenger;
	}

	public int getCapacity(){
		return capacity;
	}

	public int getPassenger(){
		return passenger;
	}

	public static void main(String[] args) {
		PassengerVehicle p1 = new PassengerVehicle(100,"Mukai",45,3,5);
		System.out.println("P1 capacity:"+p1.getCapacity()+" passenger:"+p1.getPassenger());

		PassengerVehicle p2 = new PassengerVehicle(80,"Kyon",60,5,8);
		System.out.println("P2 capacity:"+p2.getCapacity()+" passenger:"+p2.getPassenger());

		PassengerVehicle p3 = new PassengerVehicle(70,"Noguchi",70,2,5);
		System.out.println("P3 capacity:"+p3.getCapacity()+" passenger:"+p3.getPassenger());

	}


}
