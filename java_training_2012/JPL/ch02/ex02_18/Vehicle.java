package ch02.ex02_18;

public class Vehicle {
	private int speed;
	private double angle;
	private String owner;
	private int id;

	public static int nextNo =0;

	Vehicle(){
		id = nextNo++;
	}

	Vehicle(String ownerName){
		this();
		this.owner = ownerName;
	}

	Vehicle(int speed, String ownerName, double angle){
		this();
		this.speed = speed;
		this.owner = ownerName;
		this.angle = angle;
	}

	public int getSpeed(){
		return speed;
	}

	public double getAngle(){
		return angle;
	}

	public String getOwner(){
		return owner;
	}

	public int getId(){
		return id;
	}

	//追加メソッド
	public void changeSpeed(int nowSpeed){
		this.speed = nowSpeed;
	}

	//追加メソッド
	public void stop(){
		this.speed = 0;
	}

	public static void main(String[] args) {

		if(args.length != 1){
			System.out.println("Please enter a word");
		}else{
			Vehicle v = new Vehicle(args[0]);
			System.out.println(v.getOwner() + " has this car.");
		}

	}

}
