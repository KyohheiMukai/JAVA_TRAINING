package ch20.ex20_11;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class TestFileShowFilter{

	public static void main(String[] args) {
		FileShowFilter filter = new FileShowFilter();
		filter.accept(new File("JPL/ch20/ex20_11"), "txt");
	}
}
