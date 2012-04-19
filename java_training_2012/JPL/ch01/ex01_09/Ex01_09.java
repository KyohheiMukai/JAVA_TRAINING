package ch01.ex01_09;

public class Ex01_09 {

	static final int MAX_INDEX = 9;

	public static void main(String[] args){

		int[] fib = new int[MAX_INDEX];
		fib[0] = 1;
		fib[1] = 1;
		System.out.println("-----------Fibonacci---------------");

		for(int i=2; i<MAX_INDEX; i++){
			fib[i] = fib[i-2] + fib[i-1];
		}

		for(int i=0; i<MAX_INDEX; i++){
			System.out.println(i+1 +": "+fib[i]);
		}

	}

}
