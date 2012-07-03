package ch13.ex13_06;

public class CutString {

	public StringBuilder stringCutter(StringBuilder str, String c, int cutCnt){

		int index = str.indexOf(c);
		while(index!=-1){
			str.insert(++index, ",");
			index = str.indexOf(c, ++index);
		}

		int cnt = str.length();
		while(cnt>cutCnt){
			str.insert(cnt-cutCnt, ",");
			cnt = cnt-cutCnt;
		}


		return str;
	}

	public static void main(String[] args){
		CutString c = new CutString();
		System.out.println(c.stringCutter(new StringBuilder("1234567788"),"4",3));
	}

}
