package gui1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class DigitalClockWindow extends Frame implements Runnable, ActionListener{

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
	private Preferences prefs;

	final private String MENU = "Menu";
	final private String PROP = "Prop";
	final private String FONT = "Font";
	final private String SIZE = "Size";
	final private String COLOR = "Color";
	final private String GROUND_COLOR = "GroundColor";

	final private String BLACK = "black";
	final private String RED = "red";
	final private String BLUE = "blue";
	final private String WHITE = "white";

	final private int BLACK_INT = 0;
	final private int RED_INT = 1;
	final private int BLUE_INT = 2;
	final private int WHITE_INT = 3;
	private int colorNum = BLACK_INT;
	private int bgcNum = WHITE_INT;

	private int frameWidth = 300;
	private int frameHeight = 200;

	private int locationX;
	private int locationY;
	private final String LOCATION_X = "x";
	private final String LOCATION_Y = "y";

	final private Dimension D;

	private int strLength = 0;

	DigitalClockWindow(){
		super("Gui1_4");

		prefs = Preferences.systemNodeForPackage(this.getClass());

		addMenuBar();

		D = Toolkit.getDefaultToolkit().getScreenSize();

		load();
		setBounds(locationX,locationY,frameWidth,frameHeight);

		setVisible(true);

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				save();
				System.exit(0);
			}
		});

	}

	private void load(){
		font = prefs.get(FONT, Font.SANS_SERIF);
		size = prefs.getInt(SIZE, 20);
		colorNum = prefs.getInt(SIZE, BLACK_INT);
		bgcNum = prefs.getInt(SIZE, WHITE_INT);
		locationX = prefs.getInt(LOCATION_X, (D.width -  frameWidth)  / 2);
		locationY = prefs.getInt(LOCATION_Y, (D.height -  frameHeight)  / 2);

		if(colorNum == BLACK_INT){
			color = Color.black;
		}else if(colorNum == RED_INT){
			color = Color.red;
		}else{
			color = Color.blue;
		}

		groundColor = (bgcNum == BLACK_INT) ? Color.black : Color.white;
	}

	private void save(){
		prefs.put(FONT, font);
		prefs.putInt(SIZE, size);
		prefs.putInt(COLOR, colorNum);
		prefs.putInt(GROUND_COLOR, bgcNum);
		prefs.putInt(LOCATION_X, getX());
		prefs.putInt(LOCATION_Y, getY());

		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private void addMenuBar(){
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		Menu menu = new Menu(MENU);
		menu.addActionListener(this);
		menuBar.add(menu);

		MenuItem menuList = new MenuItem(PROP);
		menuList.addActionListener(this);
		menu.add(menuList);

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
				frameWidth = 200;
				frameHeight = 200;
				break;
			case 60:
				frameWidth = 300;
				frameHeight = 300;
				break;
			case 80:
				frameWidth = 600;
				frameHeight = 400;
				break;
			}
			setSize(frameWidth, frameHeight);
		}

		beforeSize = size;
	}


	public void paint(Graphics g){
		setBackground(groundColor);
		calStrLength();
		Image offImage = createImage(frameWidth, frameHeight);
		Graphics offGraphics = offImage.getGraphics();
		offGraphics.setFont(f);
		offGraphics.setColor(color);
		offGraphics.drawString(time, (frameWidth - strLength)/2, frameHeight/2);
		g.drawImage(offImage,0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals(PROP)){
			PropDlg propDlg = new PropDlg(getX(),getY(),this);
			propDlg.setVisible(true);
		}

	}

	private class PropDlg extends Dialog implements ActionListener{

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		Choice fontChoice;
		Choice sizeChoice;
		Choice colorChoice;
		Choice bgcChoice;
		public PropDlg(int x, int y, Frame owner) {
			super(owner);

			GridBagLayout gbl = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			setBounds(x+50, y+50, 200, 200);
		     Label fontLabel = new Label(FONT);
		     gbc.gridx = 0;
		     gbc.gridy = 0;
		     gbl.setConstraints(fontLabel, gbc);
		     add(fontLabel);

		     fontChoice = new Choice();
		     fontChoice.add(Font.SANS_SERIF);
		     fontChoice.add(Font.MONOSPACED);
		     fontChoice.add(Font.SERIF);
		     gbc.gridx = 1;
		     gbc.gridy = 0;
		     gbl.setConstraints(fontChoice, gbc);
		     add(fontChoice);

		     Label sizeLabel = new Label(SIZE);
		     gbc.gridx = 0;
		     gbc.gridy = 1;
		     gbl.setConstraints(sizeLabel, gbc);
		     add(sizeLabel);

		     sizeChoice = new Choice();
		     sizeChoice.add("20");
		     sizeChoice.add("60");
		     sizeChoice.add("80");
		     gbc.gridx = 1;
		     gbc.gridy = 1;
		     gbl.setConstraints(sizeChoice, gbc);
		     add(sizeChoice);

		     Label colorLabel = new Label(COLOR);
		     gbc.gridx = 0;
		     gbc.gridy = 2;
		     gbl.setConstraints(colorLabel, gbc);
		     add(colorLabel);

		     colorChoice = new Choice();
		     colorChoice.add(BLACK);
		     colorChoice.add(RED);
		     colorChoice.add(BLUE);
		     gbc.gridx = 1;
		     gbc.gridy = 2;
		     gbl.setConstraints(colorChoice, gbc);
		     add(colorChoice);

		     Label bgcLabel = new Label(GROUND_COLOR);
		     gbc.gridx = 0;
		     gbc.gridy = 3;
		     gbl.setConstraints(bgcLabel, gbc);
		     add(bgcLabel);

		     bgcChoice = new Choice();
		     bgcChoice.add(BLACK);
		     bgcChoice.add(WHITE);
		     gbc.gridx = 1;
		     gbc.gridy = 3;
		     gbl.setConstraints(bgcChoice, gbc);
		     add(bgcChoice);


		     addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						setVisible(false);
					}
				});

		     Panel btnPanel = new Panel();
		     Button okBtn = new Button("OK");
		     okBtn.addActionListener(this);
		     btnPanel.add(okBtn);
		     Button cancelBtn = new Button("Cancel");
		     cancelBtn.addActionListener(this);
		     btnPanel.add(cancelBtn);
		     gbc.gridx = 1;
		     gbc.gridy = 5;
		     gbl.setConstraints(btnPanel, gbc);
		     add(btnPanel);

		     setLayout(gbl);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("OK")){
				font = fontChoice.getSelectedItem();

				String listSize = sizeChoice.getSelectedItem();
				if(listSize!=null)
					size = Integer.parseInt(listSize);

				String decideColor = colorChoice.getSelectedItem();
				if(decideColor!=null){
					if(decideColor.equals(BLACK)){
						color = Color.black;
						colorNum = BLACK_INT;
					}else if(decideColor.equals(RED)){
						color = Color.red;
						colorNum = RED_INT;
					}else{
						color = Color.blue;
						colorNum = BLUE_INT;

					}
				}

				String decideGroundColor = bgcChoice.getSelectedItem();
				if(decideGroundColor!=null){
					groundColor = decideGroundColor.equals(BLACK) ? Color.black : Color.white;
					bgcNum = decideGroundColor.equals(BLACK) ? BLACK_INT :WHITE_INT;
				}

			}else if(e.getActionCommand().equals("Cancel")){
				/* 特に何もしない*/
			}else{
				/* 入らないはず*/
			}

			setVisible(false);

		}

	}
}