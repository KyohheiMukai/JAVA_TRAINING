package ch02.ex02_08;

public class LinkedList {

	public Object name;
	public LinkedList nextNode;

	LinkedList(Object name){
		this.name = name;
	}

	LinkedList(Object name, LinkedList nextNode){
		this(name);
		this.nextNode = nextNode;
	}

	public static void main(String[] args) {

		Vehicle car = new Vehicle("Mukai");
		car.speed = 100;
		car.angle = 45.0;
		System.out.println("[car]");
		System.out.println("speed: "+car.speed);
		System.out.println("angle: "+car.angle);
		System.out.println("owner"+car.owner);
		System.out.println("id: "+car.id);

		System.out.println();

		Vehicle track = new Vehicle("Shibata");
		track.speed = 60;
		track.angle = 30.0;
		System.out.println("[track]");
		System.out.println("speed: "+track.speed);
		System.out.println("angle: "+track.angle);
		System.out.println("owner"+track.owner);
		System.out.println("id: "+track.id);

		System.out.println();

		Vehicle spaceVehicle = new Vehicle("Noguchi");
		spaceVehicle.speed = 1000;
		spaceVehicle.angle = 75.0;
		System.out.println("[SpaceVehicle]");
		System.out.println("speed: "+spaceVehicle.speed);
		System.out.println("angle: "+spaceVehicle.angle);
		System.out.println("owner"+spaceVehicle.owner);
		System.out.println("id: "+spaceVehicle.id);

		LinkedList list3 = new LinkedList(spaceVehicle);
		LinkedList list2 = new LinkedList(track,list3);
		LinkedList list1 = new LinkedList(car,list2);

	}


}
