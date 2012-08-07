package ch14.ex14_04;

public class Test {

	public static void main(String[] args) {

		Ex4 ex4 = new Ex4(6,2);

		Thread a = new Thread(ex4);
		a.start();

		Ex4.setA(4);
		Thread b = new Thread(ex4);
		b.start();

		Ex4.setA(1);

	}
}
