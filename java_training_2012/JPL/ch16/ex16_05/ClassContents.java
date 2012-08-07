package ch16.ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public class ClassContents {

	public static void main(String[] args) {
		try{
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
			printAnnotation(c.getAnnotations());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());
		} catch(ClassNotFoundException e){
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMembers(Member[] mems){
		for(Member m : mems){
			String decl = m.toString();
			System.out.print(" ");

			decl = decl.replaceAll("java.util.","");
			decl = decl.replaceAll("java.lang.","");

			System.out.println(decl);
		}
	}

	private static void printAnnotation(Annotation[] annotation){
		for(Annotation a : annotation){
			String str = a.toString();
			System.out.print(" ");

			System.out.println(str);
		}
	}
}