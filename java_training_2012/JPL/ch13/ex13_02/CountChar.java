package ch13.ex13_02;

public class CountChar {

	public int count(String str, String ch){

		int cnt = 0;
		int index = 0;

		while(str.indexOf(ch, index)!=-1){
			cnt++;
			index = str.indexOf(ch,index) + ch.length();
		}

		return cnt;
	}

}
