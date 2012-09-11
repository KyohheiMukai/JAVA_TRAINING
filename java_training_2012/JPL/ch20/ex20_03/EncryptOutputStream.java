package ch20.ex20_03;

import java.io.FilterReader;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class EncryptOutputStream extends FilterWriter{

	protected EncryptOutputStream(Writer out) {
		super(out);
	}

	public void write(int a) throws IOException{
		super.write((char)a^2);
	}

	public static void main(String[] args) throws IOException {
		StringReader strReader = new StringReader("strTest");
		FilterReader fr = new DecryptInputStream(strReader);
		int b=-1;
		while((b=fr.read()) != -1){
			System.out.print((char)b);
		}
		System.out.println();

		//復号化は未実装です。
		StringWriter strWriter = new StringWriter();
		FilterWriter fw = new EncryptOutputStream(strWriter);
	}

}
