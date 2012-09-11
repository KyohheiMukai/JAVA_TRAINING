package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DataHandler {

//	private File lastFile;
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file){
		byte[] data = null;

		if(file.equals(lastFile)){
			data = lastData.get();
			if(data != null)
				return data;
		}

		data = readByteFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	private byte[] readByteFromFile(File file){
		return new byte[10];
	}

	/* テストコード…*/
	public static void main(String[] args) {

	}

}
