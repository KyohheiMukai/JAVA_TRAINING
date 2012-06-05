package ch07.ex07_02;

public class Primitive {

	public static void main(String[] args) {

		int tempi=0;
		long templ=0;

		byte b = 100;
		tempi = (int)b;
		System.out.println("byte b = 100");
		System.out.println("int:"+tempi);
		System.out.println();

		short s = 100;
		tempi = (int)s;
		System.out.println("short s = 100;");
		System.out.println("int:"+tempi);
		System.out.println();

		int i = 100;
		tempi = (int)i;
		System.out.println("int i = 100;");
		System.out.println("int:"+tempi);

		long l = 100;
		tempi = (int)l;
		System.out.println("long l = 100");
		System.out.println("int:"+tempi);
		System.out.println();

		double d = 100.0;
		tempi = (int)d;
		System.out.println("double d = 100.0;");
		System.out.println("int:"+tempi);
		System.out.println();

		float f = 100f;
		tempi = (int)f;
		System.out.println("float f = 100f");
		System.out.println("int:"+tempi);




	}

}
