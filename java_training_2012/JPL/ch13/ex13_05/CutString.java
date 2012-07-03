package ch13.ex13_05;

public class CutString {

	public StringBuilder stringCutter(StringBuilder str){

		int cnt = str.length();
		while(cnt>3){
			str.insert(cnt-3, ",");
			cnt = cnt-3;
		}
		return str;
	}

	public static void main(String[] args){
		CutString c = new CutString();
		System.out.println(c.stringCutter(new StringBuilder("12345")));
	}

}
