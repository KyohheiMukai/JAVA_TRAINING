package ch20.ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class SearchWord {

	public void search(String[] args) throws IOException {

		String str = args[0];
		FileReader fr = new FileReader(args[1]);
		LineNumberReader lnr = new LineNumberReader(fr);
		int ch;
		int cnt = 0;
		boolean flag = false;

		while((ch = lnr.read()) !=-1){
			//うまくいっていません。。。
			if(ch == str.charAt(cnt)){
				cnt++;
			}else{
				cnt = 0;
			}

			if(cnt == str.length()){
				flag = true;
				System.out.println("'"+str+"' at line "+lnr.getLineNumber());
				cnt = 0;
			}
		}

		if(!flag)
			System.out.println("'"+str+"' is not found.");
	}
}
