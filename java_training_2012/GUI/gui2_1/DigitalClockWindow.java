package gui2_1;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DigitalClockWindow extends JFrame implements Runnable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	String time;
	Font font;

	DigitalClockWindow(){
		super("Gui1_1");
		font = new Font("TimesRoman",Font.BOLD,24);
		time = "";

		Container con = getContentPane();
		TimerPanel p = new TimerPanel();
		con.add(p);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}



	class TimerPanel extends JPanel{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setFont(font);
			g.drawString(time, 60, 120);

		 }
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

}