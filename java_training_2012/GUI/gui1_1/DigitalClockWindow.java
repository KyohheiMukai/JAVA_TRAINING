package gui1_1;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class DigitalClockWindow extends Frame implements Runnable{

	static Thread th = new Thread();
	Graphics g;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	DigitalClockWindow(){
		super("Gui1_1");

		g = this.getGraphics();

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

	}

	@Override
	public void run() {

		while(true){

			Calendar calendar = Calendar.getInstance();
			int hour_of_day = calendar.get(Calendar.HOUR_OF_DAY );
			int min = calendar.get(Calendar.MINUTE);
			int sec = calendar.get(Calendar.SECOND);
			String time = Integer.toString(hour_of_day) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
			System.out.println(time);

			repaint();

			try{
				th.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

	public void paint(){

		Calendar calendar = Calendar.getInstance();
		g.setFont(new Font("SansSerif", Font.PLAIN, 60));

		int hour_of_day = calendar.get(Calendar.HOUR_OF_DAY );
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String time = Integer.toString(hour_of_day) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
		System.out.println(time);
		g.drawString(time, 60, 120);
	}

	public static void main(String[] args) {

		DigitalClockWindow digitalClockWindow = new DigitalClockWindow();
		digitalClockWindow.setBounds(200,200,500,500);
		digitalClockWindow.show();

		th.start();
	}

}