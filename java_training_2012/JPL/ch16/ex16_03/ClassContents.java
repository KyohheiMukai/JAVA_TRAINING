package ch16.ex16_03;

import java.lang.reflect.Member;

public class ClassContents {

	public static void main(String[] args) {
		try{
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
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
}
