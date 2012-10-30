package gui2_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DigitalClockWindow extends JFrame implements Runnable, ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String time = "";
	private Font f;
	private String font;
	private int size;
	private int beforeSize;
	private Color color;
	private Color groundColor;

	private GraphicsEnvironment ge;
	private String[] fontFamilyNames;

	final private String MENU = "Menu";
	final private String FONT = "Font";
	final private String SIZE = "Size";
	final private String COLOR = "Color";
	final private String GROUND_COLOR = "GroundColor";

	private int frameSizeWidth = 400;
	private int frameSizeHeight = 200;
	final private Dimension D;

	private int strLength = 0;

	DigitalClockWindow(){
		super("Gui2_2");

		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontFamilyNames = ge.getAvailableFontFamilyNames();

		addMenuBar();

		D = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((D.width -  frameSizeWidth)  / 2,
				  (D.height -  frameSizeHeight)  / 2,
				  frameSizeWidth,
				  frameSizeHeight);

		//デフォルトでの設定
		font = Font.SANS_SERIF;
		size = 60;
		color = Color.black;
		groundColor = Color.white;

		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void addMenuBar(){
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		Menu menu = new Menu(MENU);
		menu.addActionListener(this);
		menuBar.add(menu);

		MenuItem menuFont = new MenuItem(FONT);
		menuFont.addActionListener(this);
		menu.add(menuFont);

		MenuItem menuSize = new MenuItem(SIZE);
		menuSize.addActionListener(this);
		menu.add(menuSize);

		MenuItem menuColor = new MenuItem(COLOR);
		menuColor.addActionListener(this);
		menu.add(menuColor);

		MenuItem menuGroundColor = new MenuItem(GROUND_COLOR);
		menuGroundColor.addActionListener(this);
		menu.add(menuGroundColor);

	}

	@Override
	public void run() {

		while(true){

			repaint();

			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

	private void setTime(){

		Calendar calendar = Calendar.getInstance();

		String hour;
		if(calendar.get(Calendar.HOUR_OF_DAY)<10)
			hour = "0"+ Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
		else
			hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));

		String minute;
		if(calendar.get(Calendar.MINUTE)<10)
			minute= "0"+ Integer.toString(calendar.get(Calendar.MINUTE));
		else
			minute = Integer.toString(calendar.get(Calendar.MINUTE));


		String second;
		if(calendar.get(Calendar.SECOND)<10)
			second = "0"+ Integer.toString(calendar.get(Calendar.SECOND));
		else
			second = Integer.toString(calendar.get(Calendar.SECOND));

		time = hour + ":" + minute + ":" + second;

	}

	private void calStrLength(){

		f = new Font(font, Font.BOLD, size);
		FontMetrics fontMetrics = getFontMetrics(f);
		setTime();
		strLength = fontMetrics.stringWidth(time);

		if(beforeSize!=size){
			switch(size){
			case 20:
				frameSizeWidth = 200;
				frameSizeHeight = 200;
				break;
			case 60:
				frameSizeWidth = 300;
				frameSizeHeight = 300;
				break;
			case 100:
				frameSizeWidth = 600;
				frameSizeHeight = 400;
				break;
			}
			setSize(frameSizeWidth, frameSizeHeight);
		}

		beforeSize = size;
	}


	public void paint(Graphics g){
		setBackground(groundColor);
		calStrLength();
		Image offImage = createImage(frameSizeWidth, frameSizeHeight);
		Graphics offGraphics = offImage.getGraphics();
		offGraphics.setFont(f);
		offGraphics.setColor(color);
		offGraphics.drawString(time, (frameSizeWidth - strLength)/2, frameSizeHeight/2);
		g.drawImage(offImage,0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals(FONT)){
			FontDlg fontDlg = new FontDlg(this);
			fontDlg.setVisible(true);
		}else if(e.getActionCommand().equals(SIZE)){
			SizeDlg sizeDlg = new SizeDlg(this);
			sizeDlg.setVisible(true);
		}else if(e.getActionCommand().equals(COLOR)){
			Color color = JColorChooser.showDialog(this, "文字色の選択", Color.white);
			this.color = color;
		}else if(e.getActionCommand().equals(GROUND_COLOR)){
			Color color = JColorChooser.showDialog(this, "背景色の選択", Color.white);
			groundColor = color;
		    if(groundColor != null){
		      setBackground(groundColor);
		    }

		}

	}

	private class FontDlg extends JDialog implements ActionListener{

		private static final long serialVersionUID = 1L;
		List list;

		Choice fontChoice = null;

		public FontDlg(Frame owner) {
			super(owner);

			setLayout(new FlowLayout());

	        setTitle(FONT);
	        setBounds(300,200,200,200);

	        fontChoice = new Choice();
		     for(int i=0; i<fontFamilyNames.length; i++)
		    	 fontChoice.add(fontFamilyNames[i]);
		     fontChoice.select(font);
		     add(fontChoice);

	        Button okBtn = new Button("OK");
	        okBtn.addActionListener(this);
	        add(okBtn);

	        addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					setVisible(false);
				}
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			font = fontChoice.getSelectedItem();
			setVisible(false);
		}

	}

	private class SizeDlg extends JDialog implements ActionListener{

		private static final long serialVersionUID = 1L;
		List list;

		public SizeDlg(Frame owner) {
			super(owner);

			setLayout(new FlowLayout());

	        setTitle(FONT);
	        setBounds(300,200,200,200);

	        list = new List();
	        list.add("20");
	        list.add("60");
	        list.add("100");
	        add(list);

	        Button okBtn = new Button("OK");
	        okBtn.addActionListener(this);
	        add(okBtn);

	        addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					setVisible(false);
				}
			});

		}

		@Override
		public void actionPerformed(ActionEvent e) {
		 	String listSize =list.getSelectedItem();
			if(listSize!=null)
				size = Integer.parseInt(listSize);
			setVisible(false);
		}

	}

}