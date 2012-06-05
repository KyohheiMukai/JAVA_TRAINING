package ch09.ex09_01;

public class Operand {

	public static void main(String[] args) {
		float xPlus = Float.POSITIVE_INFINITY;
		float xMinus = Float.NEGATIVE_INFINITY;

		System.out.println("xPlus + xMinus = "+ (xPlus+xMinus));
		System.out.println("xPlus - xMinus = "+ (xPlus-xMinus));
		System.out.println("xPlus * xMinus = "+ (xPlus*xMinus));
		System.out.println("xPlus / xMinus = "+ (xPlus/xMinus));
		System.out.println();

		System.out.println("xPlus + xPlus = "+ (xPlus+xPlus));
		System.out.println("xPlus - xPlus = "+ (xPlus-xPlus));
		System.out.println("xPlus * xPlus = "+ (xPlus*xPlus));
		System.out.println("xPlus / xPlus = "+ (xPlus/xPlus));
		System.out.println();

		System.out.println("xMinus + xMinus = "+ (xMinus+xMinus));
		System.out.println("xMinus - xMinus = "+ (xMinus-xMinus));
		System.out.println("xMinus * xMinus = "+ (xMinus*xMinus));
		System.out.println("xMinus / xMinus = "+ (xMinus/xMinus));

	}

}
