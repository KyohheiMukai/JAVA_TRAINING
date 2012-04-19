package ch02.ex02_13;

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

	public Vehicle(int speed, String ownerName, double angle){
		this();
		this.speed = speed;
		this.owner = ownerName;
		this.angle = angle;
	}

	/**
	 * アクセッサ―メソッド
	 * なお、idは変更を許してはいけない
	 */
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

}
