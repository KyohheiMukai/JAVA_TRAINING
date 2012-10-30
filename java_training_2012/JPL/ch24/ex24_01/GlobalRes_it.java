package ch24.ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_it extends ListResourceBundle {

	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";

	@Override
	protected Object[][] getContents() {
		return contents;
	}

	private static final Object[][] contents ={
		{GlobalRes_it.HELLO, "Ciao"},
		{GlobalRes_it.GOODBYE, "Ciao"}
	};

}
