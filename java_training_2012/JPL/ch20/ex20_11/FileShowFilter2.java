package ch20.ex20_11;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileShowFilter2 implements FilenameFilter{

	public boolean accept(File dir, String name) {
		if(!dir.isDirectory())
			return false;

		boolean suffixFlag = false;
		File[] files = dir.listFiles();
		for(int i=0; i<files.length; i++){
			if(files[i].getName().endsWith(name)){
				System.out.println(files[i].getName());
				suffixFlag = true;
			}
		}
		if(!suffixFlag){
			System.out.println("no file: "+name);
		}
		return true;
	}
}
