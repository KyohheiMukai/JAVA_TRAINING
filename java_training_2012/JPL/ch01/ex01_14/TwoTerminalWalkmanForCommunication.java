package ch01.ex01_14;

public class TwoTerminalWalkmanForCommunication extends TwoTerminalWalkman{

	private int person = 2;
	private boolean communicationState = true;

	public void useTwoTerminalWalkmanForCommunication(){
		System.out.println("TwoTerminalWalkmanForCommunication is used.");
	}

	public boolean getCommunicationState(){
		return communicationState;
	}

}
