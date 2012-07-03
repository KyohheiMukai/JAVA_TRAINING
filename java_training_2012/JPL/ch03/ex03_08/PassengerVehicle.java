package ch03.ex03_08;

public class PassengerVehicle extends Vehicle implements Cloneable{

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

	public PassengerVehicle clone() throws CloneNotSupportedException{
		return (PassengerVehicle)super.clone();
	}

}
