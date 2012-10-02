package ch22.ex22_10;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex22_10 {

	public static List<String> cutToken(Readable readable){

		List<String> list= new ArrayList<String>();
		Scanner scanner = new Scanner(readable);
		Pattern COMMENT = Pattern.compile("#.*");
		String comment;
		while(scanner.hasNext()){
			if(scanner.hasNext(COMMENT)){
				comment = scanner.findWithinHorizon(COMMENT, 0);
				list.add(comment);
				scanner.nextLine();
			}
		}
		return list;
	}

	//うまく動きませんでした。。。
	public static void main(String[] args) {
		StringReader in = new StringReader("safas#.*feafae.kpi*");
		List<String> token = cutToken(in);
		for(int i=0; i<token.size(); i++)
			System.out.println(token.get(i));
	}

}
