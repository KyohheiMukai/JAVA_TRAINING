package ch11.ex11_01;

public class Vehicle {
	public int speed;
	public double angle;
	public String owner;
	public int id;

	public static int nextNo =0;

	Vehicle(){
		id = nextNo++;
	}

	Vehicle(String ownerName){
		this();
		this.owner = ownerName;
	}

}
