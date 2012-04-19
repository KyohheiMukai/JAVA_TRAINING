package ch01.ex01_16;

import java.io.FileInputStream;
import java.io.IOException;

public class MyUtilities {

	public byte[] getDataSet(String setName) throws BadDataSetException{
		String file = setName + ".dset";

		FileInputStream in = null;

		try{
			in = new FileInputStream(file);
			return readDataSet(in);
		}catch(IOException e){
			throw new BadDataSetException("File Open Error");
		}finally{

			try{
				if(in!=null){
					in.close();
				}
			}catch(IOException e){
				throw new BadDataSetException("File Close Error");
			}
		}
	}

	private byte[] readDataSet(FileInputStream in){
		int ch;
		byte[] buf = new byte[15];
	    try {
			in.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println(new String(buf, 0, 15));

	    return buf;

	}
}


class BadDataSetException extends Exception{

	private static final long serialVersionUID = 1L;
	String errorMsg;

	BadDataSetException(String errorMsg){
		this.errorMsg = errorMsg;
		System.out.println(errorMsg);
	}

}