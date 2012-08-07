package ch14.ex14_06;

public class MesgShowWait implements Runnable{

	private int sec;

	@Override
	public void run() {
		while(true){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			show();
		}
	}

	private synchronized void show(){
		System.out.println("Wait!!!");
	}

}
