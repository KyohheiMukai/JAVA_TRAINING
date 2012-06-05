package gui1_2;

public class DigitalClock {

	public static void main(String[] args) {

		DigitalClockWindow digitalClockWindow = new DigitalClockWindow();

		Thread th = new Thread(digitalClockWindow);
		th.start();

	}


}
