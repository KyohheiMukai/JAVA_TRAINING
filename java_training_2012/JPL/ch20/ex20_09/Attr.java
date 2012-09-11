package ch20.ex20_09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Attr {

	private final String name;
	private Object value = null;
	private double[] d;

	public Attr(String name){
		this.name = name;
		d = null;
	}

	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
		d = null;
	}

	/*追加したコンストラクタ*/
	public Attr(String name, String path) throws IOException{
		this.name = name;
		InputStream in = new FileInputStream(path);
		DataInputStream dataInputStream = new DataInputStream(in);
		d = new double[dataInputStream.readInt()];
		for(int i=0; i<d.length; i++){
			d[i] = dataInputStream.readDouble();
			System.out.println(d[i]);
		}
		dataInputStream.close();
		this.value =  null;
	}

	public String getName(){
		return name;
	}

	public Object getValue(){
		return value;
	}

	public Object setValue(Object newValue){
		Object oldValue = value;
		value = newValue;
		return oldValue;
	}

	public String toString(){
		return name + "='" + value + "'";
	}

	/* 追加メソッド*/
	public void writeData(String filePath, double[] darray) throws IOException{
		File f = new File(filePath);
		if(!f.exists())
			f.createNewFile();
		OutputStream fout = new FileOutputStream(f);
		DataOutputStream out = new DataOutputStream(fout);
		out.writeInt(darray.length);
		for(double d : darray)
			out.writeDouble(d);
		out.close();
	}
}
