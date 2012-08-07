package ch10.ex10_05;

public class PrintCharToChar {

	public void printChar(char a, char b){

		for(int i=0;i<=b-a;i++){
			System.out.print((char)(a+i));
		}
	}

	public static void main(String[] args) {
		PrintCharToChar p = new PrintCharToChar();
		p.printChar('c','k');
	}
}
