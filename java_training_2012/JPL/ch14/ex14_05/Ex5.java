package ch14.ex14_05;

public class Ex5 implements Runnable{

	private int nowCnt = 0;
	private int a;
	private int b;
	private long sleep;

	public Ex5(int a, int b, long sleep){
		this.a = a;
		this.b = b;
		this.sleep = sleep * 1000;
	}

	private synchronized void add(){
		nowCnt += a;
		System.out.println(Thread.currentThread().getName() + ":" + nowCnt);
	}

	private synchronized void differ(){
		nowCnt -= b;
		System.out.println(Thread.currentThread().getName() + ":" + nowCnt);
	}

	public void setA(int changeA){
		this.a = changeA;
	}

	@Override
	public void run() {
		for(;;){
			try {
				add();
				differ();
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
