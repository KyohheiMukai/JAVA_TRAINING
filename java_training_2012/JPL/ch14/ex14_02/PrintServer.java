package ch14.ex14_02;

public class PrintServer implements Runnable {

	private final PrintQueue req = new PrintQueue();

	public PrintServer(){
		Thread th = new Thread(this);
		th.start();
		System.out.println("Thread Start!!");
	}

	public void run() {
		print();
	}

	public void print(){
		for(;;){
			realPrint(req.remove());
		}
	}

	public void print(PrintJob printJob){
		req.add(printJob);
	}

	private void realPrint(PrintJob printJob){

	}

	public static void main(String[] args) {
		PrintServer p1 = new PrintServer();
	}

}
