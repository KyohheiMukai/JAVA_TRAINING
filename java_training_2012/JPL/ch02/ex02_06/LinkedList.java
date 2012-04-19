package ch02.ex02_06;

public class LinkedList {

	public Object name;
	public LinkedList nextNode;

	public static void main(String[] args) {

		Vehicle car = new Vehicle();
		car.speed = 100;
		car.angle = 45.0;
		car.owner = "Mukai";
		car.id = Vehicle.nextNo++;
		System.out.println("[car]");
		System.out.println("speed: "+car.speed);
		System.out.println("angle: "+car.angle);
		System.out.println("owner"+car.owner);
		System.out.println("id: "+car.id);

		System.out.println();

		Vehicle track = new Vehicle();
		track.speed = 60;
		track.angle = 30.0;
		track.owner = "Shibata";
		track.id = Vehicle.nextNo++;
		System.out.println("[track]");
		System.out.println("speed: "+track.speed);
		System.out.println("angle: "+track.angle);
		System.out.println("owner"+track.owner);
		System.out.println("id: "+track.id);

		System.out.println();

		Vehicle spaceVehicle = new Vehicle();
		spaceVehicle.speed = 1000;
		spaceVehicle.angle = 75.0;
		spaceVehicle.owner = "Noguchi";
		spaceVehicle.id = Vehicle.nextNo++;
		System.out.println("[SpaceVehicle]");
		System.out.println("speed: "+spaceVehicle.speed);
		System.out.println("angle: "+spaceVehicle.angle);
		System.out.println("owner"+spaceVehicle.owner);
		System.out.println("id: "+spaceVehicle.id);

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();

		list1.name = car;
		list1.nextNode = list2;
		list2.name = track;
		list2.nextNode = list3;
		list3.name = spaceVehicle;
		list3.nextNode = null;

	}

}
