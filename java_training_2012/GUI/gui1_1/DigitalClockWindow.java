package gui1_1;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class DigitalClockWindow extends Frame implements Runnable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	String time;
	Font font;

	DigitalClockWindow(){
		super("Gui1_1");
		font = new Font("TimesRoman",Font.BOLD,24);

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
			time = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY ))
				+ ":" + Integer.toString(calendar.get(Calendar.MINUTE))
				+ ":" + Integer.toString(calendar.get(Calendar.SECOND));

			repaint();

			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

	public void paint(Graphics g){

		g.setFont(font);
		g.drawString(time, 60, 120);
	}

}