package ch01.ex01_06;

public class Ex01_06 {

	public static void main(String[] args) {

		int lo = 1;
		int hi = 1;
		String title = "-----------Fibonacci---------------";
		System.out.println(title);
		System.out.println(lo);
		while(hi<50){
			System.out.println(hi);
			hi = lo + hi;	//新しいhi
			lo = hi - lo;	//新しいloは古いhi
		}

	}

}
