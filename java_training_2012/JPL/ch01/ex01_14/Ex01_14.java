package ch01.ex01_14;

public class Ex01_14 {

	public static void main(String[] args){

		/**
		 * 拡張したクラスには記述がないメソッドgetUserPerson()が追加されており、
		 * このメソッドは親クラスで定義されている。
		 * つまり、親クラスで定義されたメソッドは子クラスにも引き継ぐということとなる。
		 */
		TwoTerminalWalkmanForCommunication t = new TwoTerminalWalkmanForCommunication();
		int person = t.getUserPerson();
		System.out.println(person);

	}

}
