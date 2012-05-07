package ch03.ex03_09;

public class Garage implements Cloneable{

	private Vehicle[] v;
	static final int NUMBER = 3;

	public Garage clone() throws CloneNotSupportedException{
		Garage gClone = (Garage)super.clone();
		gClone.v = (Vehicle[])v.clone();
		return gClone;
	}

	Garage(Vehicle[] v){
		this.v = v;
	}

	public void print(){
		for(int i=0; i<NUMBER; i++){
			System.out.println(v[i].getOwner());
		}
	}

	public static void main(String[] args) {

		Vehicle[] v = new Vehicle[NUMBER];

		for(int i=0; i<NUMBER; i++){
			v[i] = new Vehicle("Owner"+i);
		}

		Garage g = new Garage(v);

		try {
			Garage gCopy = g.clone();

			g.print();
			System.out.println("--------------------");
			gCopy.print();

		} catch (CloneNotSupportedException e) {
			System.out.println("複製失敗");
		}

	}

}
