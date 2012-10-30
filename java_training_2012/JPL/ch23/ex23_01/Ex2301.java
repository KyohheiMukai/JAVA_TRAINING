package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Ex2301 {

	public static Process userProg(String cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	private static void plugTogether(InputStream input, OutputStream output) {
		PlugInputAndOutput plugInputAndOutput = new PlugInputAndOutput(input, output);
		Thread th = new Thread(plugInputAndOutput);
		th.start();
	}

	private static void plugTogether(PrintStream print, InputStream input) {
		PlugPrintAndInput plugPrintAndInput = new PlugPrintAndInput(print, input);
		Thread th = new Thread(plugPrintAndInput);
		th.start();
	}

	public static void main(String[] args) {
		try{
			userProg("cmd.exe");
		}catch(IOException e){
			e.printStackTrace();
		}
	}


}
