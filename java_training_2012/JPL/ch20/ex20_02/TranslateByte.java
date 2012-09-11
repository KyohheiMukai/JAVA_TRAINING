package ch20.ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader{

	byte from;
	byte to;

	protected TranslateByte(Reader in, String map, String str) {
		super(in);

		from = (byte)map.charAt(0);
		to = (byte)str.charAt(0);
	}

	public int read() throws IOException{
		int b = super.read();
		return (b ==from ?  to : b);
	}

	public static void main(String[] args) throws IOException {
		StringReader stringReader = new StringReader("abcde");
		FilterReader fileReader = new TranslateByte(stringReader, "d", "D");
		int c;
		while((c = fileReader.read()) != -1){
			System.out.print((char)c);
		}
	}
}
