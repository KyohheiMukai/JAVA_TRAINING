package ch21.ex21_02;

import java.io.File;
import java.util.WeakHashMap;

public class DataHandler {

	private File lastFile;
	private WeakHashMap lastMap;

	byte[] readFile(Object key,File file){
		byte[] data;

		//データを記憶しているか調べる
		if(file.equals(lastFile)){
			data = (byte[]) lastMap.get(key);
			if(data!=null)
				return data;
		}

		//記憶していないので読み込む
		data = readByteFromFile(file);
		lastFile = file;
		lastMap.put(key, data);
		return data;
	}

	private byte[] readByteFromFile(File file){
		return new byte[10];
	}

}
