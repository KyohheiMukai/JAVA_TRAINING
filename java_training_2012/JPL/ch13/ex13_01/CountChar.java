package ch13.ex13_01;

public class CountChar {

	public int count(String str, char ch){

		int cnt = 0;
		for(int i=0; i<str.length(); i++){
			if(ch == str.charAt(i))
				cnt++;
		}
		return cnt;
	}

}
