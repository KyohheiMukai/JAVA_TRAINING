package ch20.ex20_05;

import java.io.IOException;

public class TestSearchWord {

	public static void main(String[] args) throws IOException {

		String[] str = {"SHELL32","C:\\lv.log"};
		SearchWord sw = new SearchWord();
		sw.search(str);

	}

}
