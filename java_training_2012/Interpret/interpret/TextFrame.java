package interpret;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextFrame extends JFrame {

	JTextArea text = null;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	TextFrame() {
	      getContentPane().setLayout(new FlowLayout());

	      text = new JTextArea("", 30, 50);
	      text.setLineWrap(true);
	      getContentPane().add(text);

	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setTitle("Message");
	      setSize(700, 700);
	      setVisible(true);
	}

	public void append(String message) {
		text.append(message + "\n");
	}

}
