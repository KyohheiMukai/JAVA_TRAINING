package ch20.ex20_01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TranslateByte {

	public static void main(String[] args) throws UnsupportedEncodingException {

		OutputStream outputStream = null;
		try {
			outputStream = translate(args[0], args[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		OutputStreamWriter out = new OutputStreamWriter(outputStream, "UTF-8");
	}

	public static OutputStream translate(String map, String str) throws IOException{
		OutputStream os = new FileOutputStream("JPL/ch20/ex20_01/output.txt");

		InputStream in = System.in;
		byte from = (byte) map.charAt(0);
		byte to = (byte)str.charAt(0);
		int b = 0;
		while((b = in.read())  != -1){
			os.write(b==from ?  to : b);
			os.flush();
		}
		return os;
	}
}
