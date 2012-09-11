package ch20.ex20_07;

import java.io.IOException;

public class AttrTest {

	public static void main(String[] args) throws IOException {
		Integer in = new Integer(3);
		Attr a = new Attr("aa", in);
		double[] darray = {2.4,3.4,32.2};
		a.writeData("JPL/ch20/ex20_07/a.txt", darray);
		Attr a2 = new Attr("a2","JPL/ch20/ex20_07/a.txt");
	}
}
