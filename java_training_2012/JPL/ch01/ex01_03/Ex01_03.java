package ch01.ex01_03;

public class Ex01_03 {

	public static void main(String[] args){
		int lo = 1;
		int hi = 1;
		System.out.println("-----------Fibonacci---------------");
		System.out.println(lo);
		while(hi<50){
			System.out.println(hi);
			hi = lo + hi;	//新しいhi
			lo = hi - lo;	//新しいloは古いhi
		}
	}

}
