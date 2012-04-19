package ch02.ex02_17;

public class Vehicle {
	private int speed;
	private double angle;
	private String owner;
	private int id;

	public static int nextNo =0;

	public static final int TURN_LEFT = 0;
	public static final int TURN_RIGHT = 1;

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

	/**
	 * 追加メソッド（オーバーロード）
	 * @param angle
	 */
	public void turn(double angle){
		this.angle += angle;
	}

	/**
	 * 追加メソッド（オーバーロード）
	 * @param turn
	 */
	public void turn(int turn){
		if(turn==Vehicle.TURN_RIGHT){
			this.angle += 90.0;
		}else{
			this.angle -= 90.0;
		}
	}

	public int getSpeed(){
		return speed;
	}

	public void changeSpeed(int nowSpeed){
		this.speed = nowSpeed;
	}

	public void stop(){
		this.speed = 0;
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
