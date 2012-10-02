package ch22.ex22_05;

import java.util.Random;

public class Dice {


	/**
	 * サイコロを作り、合計値を出す…ところまではできた
	 * @param args
	 */
	public static void main(String[] args) {

		Random r = new Random();
		int number = 2;

		int t = 0;
		for(int i=0;i<number;i++){
			int add = r.nextInt(6)+1;
			System.out.println(add);
			t +=  add;
		}
		System.out.println("total:"+t);
	}

}
