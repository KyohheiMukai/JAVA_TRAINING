package ch14.ex14_03;

public class Test {

	public static void main(String[] args) {

		Ex3 ex3 = new Ex3(6,2);

		Thread a = new Thread(ex3);
		a.start();

		Thread b = new Thread(ex3);
		b.start();

		ex3.setA(4);

	}
}
