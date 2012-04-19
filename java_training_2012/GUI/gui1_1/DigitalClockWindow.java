package gui1_1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DigitalClockWindow extends Frame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	DigitalClockWindow(){
		super("Gui1_1");

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		
	}



}
