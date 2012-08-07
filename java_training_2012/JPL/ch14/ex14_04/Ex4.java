package ch14.ex14_04;

public class Ex4 implements Runnable{

	private static int nowCnt = 0;
	private static int a;
	private long sleep;

	public Ex4(int a, long sleep){
		this.a = a;
		this.sleep = sleep * 1000;
	}

	private static void add(){
		nowCnt += a;
		System.out.println(nowCnt);
	}

	public static void setA(int changeA){
		a = changeA;
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
