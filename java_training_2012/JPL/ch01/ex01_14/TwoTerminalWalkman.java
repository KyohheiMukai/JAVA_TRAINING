package ch01.ex01_14;

public class TwoTerminalWalkman extends OneTerminalWalkman{

	private int person = 2;

	public void useTwoTerminalWalkman(){
		System.out.println("TwoTerminalWalkman is used.");
	}

	public int getUserPerson(){
		return person;
	}

}
