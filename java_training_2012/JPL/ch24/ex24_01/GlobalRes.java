package ch24.ex24_01;

public class GlobalRes {

	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";

	protected Object[][] getContents() {
		return contents;
	}

	private static final Object[][] contents ={
		{GlobalRes_it.HELLO, "kon'nichiwa!"},
		{GlobalRes_it.GOODBYE, "sayonara!!"}
	};
}
