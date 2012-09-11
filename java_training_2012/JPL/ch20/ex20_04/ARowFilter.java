package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class ARowFilter extends FilterReader {

	protected ARowFilter(Reader in) {
		super(in);
	}

	public int read() throws IOException{
		return super.read();
	}

	public static void aRow() throws IOException{
		int b = -1;
		while((b = System.in.read()) != -1){
			System.out.write((char)b);
		}
	}

	//すみません、実行できません…
	public static void main(String[] args) {
		try {
			aRow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
