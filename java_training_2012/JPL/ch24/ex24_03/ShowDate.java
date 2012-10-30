package ch24.ex24_03;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ShowDate {

	public static void show(String dateStr){
		System.out.print(dateStr);
		try {
			Date date = DateFormat.getDateInstance().parse(dateStr);

			Format shortFmt = DateFormat.getDateInstance(DateFormat.SHORT);
			Format midiumFmt = DateFormat.getDateInstance(DateFormat.MEDIUM);
			Format longFmt = DateFormat.getDateInstance(DateFormat.LONG);
			Format fullFmt = DateFormat.getDateInstance(DateFormat.FULL);

			System.out.println();
			System.out.println("SHORT:"+shortFmt.format(date));
			System.out.println("MIDIUM:"+midiumFmt.format(date));
			System.out.println("LONG:"+longFmt.format(date));
			System.out.println("FULL:"+fullFmt.format(date));

		} catch (ParseException e) {
			System.out.println(" : parse failed.");
		} finally{
			System.out.println("--------------------------------");
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.JAPAN);
		show("2012/10/27");
		show("27/10/2012");
		show("10/27/2012");
		show("2012.10.27");
	}

}
