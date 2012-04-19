package ch01.ex01_07;

public class Ex01_07 {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に'*'をつけ、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 * @param args
	 */
	public static void main(String[] args) {

		int hi = 34;
		int lo = 13;
		String mark;

		System.out.println("9: "+hi + " *");

		for(int i=MAX_INDEX-1; i>0; i--){
			hi = hi - lo;
			if(hi%2==0)
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			lo = hi - lo;
		}

	}

}
