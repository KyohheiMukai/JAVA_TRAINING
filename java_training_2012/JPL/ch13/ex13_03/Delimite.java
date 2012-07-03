package ch13.ex13_03;

import java.util.ArrayList;

public class Delimite {

	public static ArrayList<String> delimitedStringArray(String from, char start, char end){

		ArrayList<String> list = new ArrayList<String>();

		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		do{
			if(endPos == -1){
				from = from.substring(startPos);
				list.add(from);
				break;
			}else if(startPos==-1||startPos>endPos){
				break;
			}else{
				from = from.substring(startPos, endPos + 1);
				list.add(from);
			}
			startPos = from.indexOf(start, startPos + 1);
			endPos = from.lastIndexOf(end, endPos - 1);
		}while(startPos != -1);

		return list;
	}
}
