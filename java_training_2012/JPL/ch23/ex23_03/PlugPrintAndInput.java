package ch23.ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PlugPrintAndInput implements Runnable {

	private PrintStream print =null;
	private BufferedReader br = null;
	private String str;

	public PlugPrintAndInput(PrintStream print, InputStream input) {
		this.print = print;
		br = new BufferedReader(new InputStreamReader(input));
	}

	@Override
	public void run() {
		try {
			while((str=br.readLine()) != null){
				print.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
