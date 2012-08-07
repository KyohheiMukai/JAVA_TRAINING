package ch14.ex14_05;

public class Test {

	public static void main(String[] args) {

		Ex5 ex5 = new Ex5(6,2,3);

		Thread a = new Thread(ex5);
		a.setName("ThreadA");
		a.start();

		Thread b = new Thread(ex5);
		b.setName("ThreadB");
		b.start();
	}
}
