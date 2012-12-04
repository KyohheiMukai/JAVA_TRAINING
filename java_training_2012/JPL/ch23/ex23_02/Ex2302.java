package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class Ex2302 {

	private static BufferedReader br;
    private static String str;

    public static void main(String[] args) {

	   	 try{
	         br = new BufferedReader(new StringReader(args[0]));
	         str = br.readLine();
	         Process proc = Runtime.getRuntime().exec(str);

	     }catch(Exception e){
	    	 e.printStackTrace();
	     }

	}


}
