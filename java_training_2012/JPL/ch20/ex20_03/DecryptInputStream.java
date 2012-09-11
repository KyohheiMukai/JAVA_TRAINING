package ch20.ex20_03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class DecryptInputStream extends FilterReader{

	protected DecryptInputStream(Reader in) {
		super(in);
	}

	public int read() throws IOException{
		int b = super.read();
		if(b != -1)
			return b^2;
		else
			return -1;
	}

}
