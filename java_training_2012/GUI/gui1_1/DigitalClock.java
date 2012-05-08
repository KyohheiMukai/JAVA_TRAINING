package gui1_1;

public class DigitalClock {

	public static void main(String[] args) {

		DigitalClockWindow digitalClockWindow = new DigitalClockWindow();
		digitalClockWindow.setBounds(200,200,200,200);
		digitalClockWindow.setVisible(true);

		Thread th = new Thread(digitalClockWindow);
		th.start();

	}


}
