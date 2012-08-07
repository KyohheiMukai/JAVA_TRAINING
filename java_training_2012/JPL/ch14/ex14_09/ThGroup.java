package ch14.ex14_09;

public class ThGroup {

	public void startTh(ThreadGroup thGroup){

		Thread[] threads = new Thread[thGroup.activeCount()];
		thGroup.enumerate(threads);
		for(int i=0; i<threads.length; i++)
			System.out.println(threads[i].getName());;
	}

	public static void main(String[] args) {
		ThreadGroup thGroup = Thread.currentThread().getThreadGroup();
		Thread th1 = new Thread(thGroup , new RunA());
		Thread th2 = new Thread(thGroup , new RunB());
		th1.start();
		th2.start();
		ThGroup tg = new ThGroup();
		tg.startTh(thGroup);
	}

}
