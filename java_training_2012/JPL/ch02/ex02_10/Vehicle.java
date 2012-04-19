package ch02.ex02_10;

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

	//追加メソッド
	public String toString(){
		String strShow = "";
		strShow = "speed: "+speed;
		strShow += " angle: "+angle;
		strShow += " owner: "+owner;
		strShow += " id: "+id;
		return strShow;
	}

	public static int getMaxOfId(){
		return nextNo;
	}

	public static void main(String[] args){
		Vehicle car = new Vehicle("Mukai");
		car.speed = 100;
		car.angle = 45.0;
		System.out.println("[car]");
		System.out.println(car.toString());

		System.out.println();

		Vehicle track = new Vehicle("Shibata");
		track.speed = 60;
		track.angle = 30.0;
		System.out.println("[track]");
		System.out.println(track.toString());

		System.out.println();

		Vehicle spaceVehicle = new Vehicle("Noguchi");
		spaceVehicle.speed = 1000;
		spaceVehicle.angle = 75.0;
		System.out.println("[SpaceVehicle]");
		System.out.println(spaceVehicle.toString());

	}
}
