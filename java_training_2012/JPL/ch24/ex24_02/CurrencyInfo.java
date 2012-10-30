package ch24.ex24_02;

import java.util.Currency;
import java.util.Locale;

public class CurrencyInfo {

	private static final int num = 6;
	public static void main(String[] args) {
		Locale[] locale = new Locale[num];
		Currency[] currency = new Currency[num];

		locale[0] = Locale.US;
		currency[0] = Currency.getInstance(locale[0]);
		locale[1] = Locale.UK;
		currency[1] = Currency.getInstance(locale[1]);
		locale[2] = Locale.FRANCE;
		currency[2] = Currency.getInstance(locale[2]);
		locale[3] = Locale.CHINA;
		currency[3] = Currency.getInstance(locale[3]);
		locale[4] = Locale.GERMANY;
		currency[4] = Currency.getInstance(locale[4]);
		locale[5] = Locale.JAPAN;
		currency[5] = Currency.getInstance(locale[5]);

		for(int i=0; i<locale.length; i++){
			Locale.setDefault(locale[i]);
			System.out.print(locale[i].getCountry() + " : ");
			for(int j=0; j<currency.length; j++){
				System.out.print(currency[j].getSymbol() + "   ");
			}
			System.out.println();
		}

	}
}
