package gui1_3;


import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class DigitalClockWindow extends Window implements ActionListener,Runnable{

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
	private PopupMenu popupMenu;
	private PopupMenu menuFont;
	private PopupMenu menuSize;
	private PopupMenu menuColor;
	private PopupMenu menuGroundColor;

	final private String FONT = "Font";
	final private String SIZE = "Size";
	final private String COLOR = "Color";
	final private String GROUND_COLOR = "GroundColor";

	final private String BLACK = "Black";
	final private String RED = "Red";
	final private String BLUE = "Blue";
	final private String WHITE = "White";
	final private String CYAN = "Cyan";

	private int frameSizeWidth = 300;
	private int frameSizeHeight = 200;
	final private Dimension D;
	private MouseEvent start;

	private int strLength = 0;

	ActionListener actionListener;

	DigitalClockWindow(){
		super(null);

		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		popupMenu = new PopupMenu();
		addPopupMenu();

		MouseListener mouseListener = new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getModifiers() == InputEvent.BUTTON3_MASK)
					popupMenu.show(DigitalClockWindow.this, e.getX(),e.getY());
			}
		};
		addMouseListener(mouseListener);
		add(popupMenu);
		addMouseListener(new WindowDrugMove());
		addMouseMotionListener(new WindowDrugMove());


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



		setVisible(true);

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

	}


	private void addPopupMenu(){

		menuFont = new PopupMenu(FONT);
		fontMenu();
		menuFont.addActionListener(this);
		popupMenu.add(menuFont);

		menuSize = new PopupMenu(SIZE);
		sizeMenu();
		menuSize.addActionListener(this);
		popupMenu.add(menuSize);

		menuColor = new PopupMenu(COLOR);
		colorMenu();
		menuColor.addActionListener(this);
		popupMenu.add(menuColor);

		menuGroundColor = new PopupMenu(GROUND_COLOR);
		gColorMenu();
		menuGroundColor.addActionListener(this);
		popupMenu.add(menuGroundColor);

	}

	private void fontMenu(){
		MenuItem m1 = new MenuItem(Font.SANS_SERIF);
		m1.setActionCommand(Font.SANS_SERIF);
		menuFont.add(m1);

		MenuItem m2 = new MenuItem(Font.MONOSPACED);
		m2.setActionCommand(Font.MONOSPACED);
		menuFont.add(m2);

		MenuItem m3 = new MenuItem(Font.SERIF);
		m3.setActionCommand(Font.SERIF);
		menuFont.add(m3);

	}

	private void sizeMenu(){

		MenuItem m1 = new MenuItem("20");
		m1.setActionCommand("20");
		menuSize.add(m1);

		MenuItem m2 = new MenuItem("60");
		m2.setActionCommand("60");
		menuSize.add(m2);

		MenuItem m3 = new MenuItem("100");
		m3.setActionCommand("100");
		menuSize.add(m3);

	}

	private void colorMenu(){

		MenuItem m1 = new MenuItem(BLACK);
		m1.setActionCommand(BLACK);
		menuColor.add(m1);

		MenuItem m2 = new MenuItem(RED);
		m2.setActionCommand(RED);
		menuColor.add(m2);

		MenuItem m3 = new MenuItem(BLUE);
		m3.setActionCommand(BLUE);
		menuColor.add(m3);

	}

	private void gColorMenu(){

		MenuItem m1 = new MenuItem(CYAN);
		m1.setActionCommand(CYAN);
		menuGroundColor.add(m1);

		MenuItem m2 = new MenuItem(WHITE);
		m2.setActionCommand(WHITE);
		menuGroundColor.add(m2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Font.SANS_SERIF)){
			font = Font.SANS_SERIF;
		}else if(e.getActionCommand().equals(Font.MONOSPACED)){
			font = Font.MONOSPACED;
		}else if(e.getActionCommand().equals(Font.SERIF)){
			font = Font.SERIF;
		}else if(e.getActionCommand().equals("20")){
			size = 20;
		}else if(e.getActionCommand().equals("60")){
			size = 60;
		}else if(e.getActionCommand().equals("100")){
			size = 100;
		}else if(e.getActionCommand().equals(BLACK)){
			color = Color.black;
		}else if(e.getActionCommand().equals(BLUE)){
			color = Color.BLUE;
		}else if(e.getActionCommand().equals(RED)){
			color = Color.RED;
		}else if(e.getActionCommand().equals(CYAN)){
			groundColor = Color.CYAN;
		}else if(e.getActionCommand().equals(WHITE)){
			groundColor = Color.WHITE;
		}
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
		//ダブルバッファリング処理を追加
		Image offImage = createImage(frameSizeWidth, frameSizeHeight);
		Graphics offGraphics = offImage.getGraphics();
		offGraphics.setFont(f);
		offGraphics.setColor(color);
		offGraphics.drawString(time, (frameSizeWidth - strLength)/2, frameSizeHeight/2);
		g.drawImage(offImage,0,0,this);
	}

	/**
	 * ダブルバッファリング
	 */
	public void update(Graphics g){
		paint(g);
	}

	class WindowDrugMove implements MouseMotionListener, MouseListener{
		private Point loc;
		public void mouseMoved(MouseEvent me){}
		public void mouseDragged(MouseEvent me){
			Window window = DigitalClockWindow.this;
			loc = window.getLocation(loc);
			System.out.println(loc.x + ","+loc.y);
			int x = loc.x - start.getX() + me.getX();
			int y = loc.y - start.getY() + me.getY();
			window.setLocation(x, y);
		}
		public void mouseClicked(MouseEvent me){ start=me; }
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
		public void mousePressed(MouseEvent me) { start=me; }
		public void mouseReleased(MouseEvent me){}
		}

}