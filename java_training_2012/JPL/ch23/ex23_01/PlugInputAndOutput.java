package ch23.ex23_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PlugInputAndOutput implements Runnable {

	private InputStream input = null;
	private OutputStream output = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private String str;

	public PlugInputAndOutput(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
		InputStreamReader isr = new InputStreamReader(input);
		br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(output);
		bw = new BufferedWriter(osw);
	}

	@Override
	public void run() {
		try {
			while((str = br.readLine()) != null){
				bw.write(str);
				System.out.println(bw);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
