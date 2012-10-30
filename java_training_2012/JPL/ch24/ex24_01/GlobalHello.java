package ch24.ex24_01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {

	public static void main(String[] args) {

		//ListResourceBundle
		Locale.setDefault(Locale.ITALY);
		ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
		String msg;
		if(args.length > 0)
			msg = res.getString(GlobalRes.GOODBYE);
		else
			msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);

		//propertiesファイル
		Locale.setDefault(Locale.US);
		res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
		if(args.length > 0)
			msg = res.getString("GOODBYE");
		else
			msg = res.getString("HELLO");
		System.out.println(msg);

		//ResourceBundleのサブクラス
		Locale.setDefault(Locale.FRANCE);
		res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
		if(args.length > 0)
			msg = res.getString(GlobalRes.GOODBYE);
		else
			msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
	}

}
