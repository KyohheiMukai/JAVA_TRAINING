package ch14.ex14_01;

public class ShowThreadName extends Thread{

	private long delayTime;

	ShowThreadName(String threadName, long time){
		setName(threadName);
		this.delayTime = time;
	}

	public void run(){
		try{
			for(;;){
				System.out.println(getName());
				Thread.sleep(delayTime);
			}
		}catch (InterruptedException e){
			return;
		}
	}

	public static void main(String[] args) {
		ShowThreadName s1 = new ShowThreadName("obj1",2000);
		ShowThreadName s2 = new ShowThreadName("obj2",5000);

		s1.start();
		s2.start();
	}

}
