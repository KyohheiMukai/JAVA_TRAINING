package ch16.ex16_04;

import java.lang.annotation.Annotation;

public class Ex4 {

	static Class<?> cls;

	public static void main(String[] args) {
		try {
			cls = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		printAnnotation(cls.getAnnotations());

	}

	private static void printAnnotation(Annotation[] annotation){
		for(Annotation a : annotation){
			String str = a.toString();
			System.out.print(" ");

			System.out.println(str);
		}

	}

}
