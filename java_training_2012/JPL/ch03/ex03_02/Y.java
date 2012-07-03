package ch03.ex03_02;

public class Y extends X {

	protected int yMask = 0xff00;

	public Y(){
		print();
		fullMask |= yMask;
		print();
	}

	public static void main(String[] args) {
		new Y();
	}

	public void print(){
		System.out.printf("xMask: %x, yMask: %x, fullMask: %x",xMask,yMask,fullMask);
		System.out.println();
	}

}
