package ch01.ex01_10;

public class Ex01_10 {

	static final int MAX_INDEX = 9;

	public static void main(String[] args){
		Fib[] fib = new Fib[MAX_INDEX];
		for(int i=0; i<fib.length; i++)
			fib[i] = new Fib();
		fib[0].number = 1;
		fib[1].number = 1;

		for(int i=0; i<MAX_INDEX; i++){
			if(i>1)
				fib[i].number = fib[i-2].number + fib[i-1].number;

			if(fib[i].number%2==0)
				fib[i].evenFlag = true;
			else
				fib[i].evenFlag = false;
		}

		for(int i=0; i<MAX_INDEX; i++){
			System.out.print((i+1) + ": " + fib[i].number);
			if(fib[i].evenFlag==true)
				System.out.println(" *");
			else
				System.out.println();
		}
	}

}
