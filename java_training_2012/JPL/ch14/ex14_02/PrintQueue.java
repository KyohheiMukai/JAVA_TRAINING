package ch14.ex14_02;

public class PrintQueue {

	private PrintJob printJob;
	PrintQueue(){

	}

	void add(PrintJob printJob){
		/* 何か処理を加える*/
		this.printJob = printJob;
	}

	public PrintJob remove() {
		return printJob;
	}

}
