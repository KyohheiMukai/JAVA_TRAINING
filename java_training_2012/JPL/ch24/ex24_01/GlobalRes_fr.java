package ch24.ex24_01;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class GlobalRes_fr extends ResourceBundle{

	@Override
	protected Object handleGetObject(String key) {
		if(key.equals(GlobalRes.HELLO))
			return "yaa!";
		else if(key.equals(GlobalRes.GOODBYE))
			return "hey!!";
		else
			return null;
	}

	//すみません、何を実装すればよいか分かりませんでした。
	public Enumeration<String> getKeys() {
		return null;
	}

}
