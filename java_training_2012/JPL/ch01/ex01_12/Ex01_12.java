package ch01.ex01_12;

public class Ex01_12 {

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
			String strForShow = (i+1) + ": " + fib[i].number;
			String ast = " *";

			System.out.print(strForShow);
			if(fib[i].evenFlag==true)
				System.out.println(ast);
			else
				System.out.println();
		}
	}

}
