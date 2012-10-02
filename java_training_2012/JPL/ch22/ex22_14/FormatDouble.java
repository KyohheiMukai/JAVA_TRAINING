package ch22.ex22_14;

import java.util.StringTokenizer;

public class FormatDouble {

	public static void plus(String dStr){

		StringTokenizer token = new StringTokenizer(dStr, " ");
		double result = 0;
		while(token.hasMoreTokens()){
			double d = Double.parseDouble(token.nextToken());
			System.out.println(d);
			result += d;
		}
		System.out.println("result:"+result);
	}


	public static void main(String[] args) {
		String d = "1.3 2.3333 1.444123";
		plus(d);
	}

}
