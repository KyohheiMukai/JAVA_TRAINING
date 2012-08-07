package ch14.ex14_06;

public class MesgShow implements Runnable{

	private int countSec = 0;

	MesgShow(){
		MesgShowWait mesgShowWait = new MesgShow.MesgShowWait();
		new Thread(mesgShowWait).start();
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			showTimer();
		}
	}

	private synchronized void showTimer(){
		countSec++;
		System.out.println(countSec);
		notifyAll();
	}

	public static void main(String[] args) {
		MesgShow mesgShow = new MesgShow();
		new Thread(mesgShow).start();
	}

	public class MesgShowWait extends Thread{

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

}
