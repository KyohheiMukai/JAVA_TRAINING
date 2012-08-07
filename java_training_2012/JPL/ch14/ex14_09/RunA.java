package ch14.ex14_09;

public class RunA implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
