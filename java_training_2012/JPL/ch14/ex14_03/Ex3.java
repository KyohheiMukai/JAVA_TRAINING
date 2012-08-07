package ch14.ex14_03;

public class Ex3 implements Runnable{

	private int nowCnt = 0;
	private int a;
	private long sleep;

	public Ex3(int a, long sleep){
		this.a = a;
		this.sleep = sleep * 1000;
	}

	private void add(){
		nowCnt += a;
		System.out.println(nowCnt);
	}

	public void setA(int changeA){
		this.a = changeA;
	}

	@Override
	public void run() {
		for(;;){
			try {
				add();
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
