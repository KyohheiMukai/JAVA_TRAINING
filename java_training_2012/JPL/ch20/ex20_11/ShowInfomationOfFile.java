package ch20.ex20_11;

import java.io.File;
import java.io.IOException;

public class ShowInfomationOfFile {

	public static void showInfo(String[] filePath) throws IOException{
		File[] files = new File[filePath.length];
		for(int i=0; i<files.length; i++){
			files[i] = new File(filePath[i]);

			System.out.println("getName():"+files[i].getName());
			System.out.println("getPath():"+files[i].getPath());
			System.out.println("getAbsolutePath():"+files[i].getAbsolutePath());
			System.out.println("getCanonicalPath():"+files[i].getCanonicalPath());
			System.out.println("getParent():"+files[i].getParent());
			System.out.println("lastModified():"+files[i].lastModified());
			System.out.println("length():"+files[i].length());
			System.out.println("exists():"+files[i].exists());
			System.out.println();

		}
	}

	public static void main(String[] args) {
		String[] files = {"JPL/ch20/ex20_09/a.txt","JPL/ch20/ex20_09/AttrTest.java", "JPL/ch20/ex20_09/Attr.java"};
		try {
			showInfo(files);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
