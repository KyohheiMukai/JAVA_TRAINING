package interpret;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class InterpretGui extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Container contentPane;
	JTextField text1;
	JTextField methodParamField;
	JTextField argsField;
	JTextField arrayField;
	JPanel firstPanel;
	JButton button1;
	JButton fieldSetButton;
	JButton callMethodButton;
	JButton constructorButton;
	JButton instanceButton;
	JButton newInstanceButton;
	JButton arrayButton;
	JButton arrayToInstanceButton;
	JTextField[] text2;
	JPanel fieldSetPanel;
	Field[] f;
	Method[] methods;
	Class<?> cls;
	JTable fieldSetTable;
	DefaultTableModel fieldSetModel;
	JTable callMethodTable;
	DefaultTableModel callMethodModel;
	JTable arrayTable;
	DefaultTableModel arrayModel;
	JTable constructorTable;
	DefaultTableModel constructorModel;
	JTable firstTable;
	DefaultTableModel firstModel;
	JPanel callMethodPanel;
	JPanel arrayPanel;
	JPanel constructorPanel;
	TextFrame text;

	JPanel bigPanel;
	ClassLoader loader = ClassLoader.getSystemClassLoader();

	private InstanceGui gui;
	private boolean isCreatingObject = false;
	private int controlList = 0;
	Object createObj = null;
	Object arrayObj = null;

	private String[] createColumnNames = {"Type","Length"};
	private String[] arrayColumnNames = {"Type","Name"};
	private String[] constructorColumnNames = {  "Construcor"};

	InterpretGui(){

		setTitle("Interpret");

		text = new TextFrame();
		text.setBounds(100, 100, 700, 500);
		gui = new InstanceGui(text);
		gui.setBounds(800,400,700,700);

		setBounds(300,300,700,700);
		setLocationRelativeTo(null);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbcPanel = new GridBagConstraints();

		firstPanel = new JPanel();
		firstModel = new DefaultTableModel(1,2);
		firstModel.setColumnIdentifiers(createColumnNames);
		firstTable = new JTable(firstModel);
		JScrollPane fistScrollpane = new JScrollPane(firstTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(fistScrollpane, gbcPanel);
		firstPanel.add(fistScrollpane);
		instanceButton = new JButton("CallConstructor");
		instanceButton.addActionListener(new CallConstructorListener());
		instanceButton.setSize(120, 120);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(instanceButton, gbcPanel);
		firstPanel.add(instanceButton);
		arrayButton = new JButton("CreateArray");
		arrayButton.addActionListener(new CreateArrayAndConstructorListener());
		arrayButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(arrayButton, gbcPanel);
		firstPanel.add(arrayButton);
		firstPanel.setLayout(gbl);

		arrayPanel = new JPanel();
		arrayModel = new DefaultTableModel(0,2);
		arrayModel.setColumnIdentifiers(arrayColumnNames);
		arrayTable = new JTable(arrayModel);
		//arrayTable.setAutoCreateRowSorter(true);
		arrayTable.getSelectionModel().addListSelectionListener(new ArrayToConstructorListener());
		JScrollPane arrayScrollpane = new JScrollPane(arrayTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(arrayScrollpane, gbcPanel);
		arrayPanel.add(arrayScrollpane);
		arrayPanel.setLayout(gbl);

		constructorPanel = new JPanel();
		constructorModel = new DefaultTableModel(0,1);
		constructorModel.setColumnIdentifiers(constructorColumnNames);
		constructorTable= new JTable(constructorModel);
		JScrollPane constructorScrollpane = new JScrollPane(constructorTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(constructorScrollpane, gbcPanel);
		constructorPanel.add(constructorScrollpane);
		argsField = new JTextField(20);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(argsField, gbcPanel);
		constructorPanel.add(argsField);
		newInstanceButton = new JButton("newInstance");
		newInstanceButton.addActionListener(new ObjectInstanceListener());
		newInstanceButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(newInstanceButton, gbcPanel);
		constructorPanel.add(newInstanceButton);

		arrayToInstanceButton = new JButton("newInstance(Array)");
		arrayToInstanceButton.addActionListener(new ArraytoInstanceListener());
		arrayToInstanceButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 2;
		gbl.setConstraints(arrayToInstanceButton, gbcPanel);
		constructorPanel.add(arrayToInstanceButton);
		constructorPanel.setLayout(gbl);
		constructorPanel.add(arrayToInstanceButton);

		bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(2,3));
		bigPanel.add(firstPanel);
		bigPanel.add(arrayPanel);
		bigPanel.add(constructorPanel);

		JScrollPane bigScrollpane = new JScrollPane(bigPanel);
		bigScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bigScrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(bigScrollpane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		text.setVisible(true);
		setVisible(true);
	}

	public void callTest(){
		text.append("interpret invoke()");
	}

	class CreateArrayAndConstructorListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			try {
				String aryStr = (String)firstTable.getValueAt(0, 0);

				Class<?> clazz = null;

				if(aryStr.startsWith("int")){
					clazz = int.class;
				}else if(aryStr.startsWith("char")){
					clazz = char.class;
				}else if(aryStr.startsWith("long")){
					clazz = long.class;
				}else if(aryStr.startsWith("double")){
					clazz = double.class;
				}else if(aryStr.startsWith("float")){
					clazz = float.class;
				}else if(aryStr.startsWith("short")){
					clazz = short.class;
				}else if(aryStr.startsWith("byte")){
					clazz = byte.class;
				}else if(aryStr.startsWith("boolean")){
					clazz = boolean.class;
				}else{
					clazz = Class.forName(aryStr);
				}

				if((String)firstTable.getValueAt(0, 1) != null){
					int length = Integer.parseInt((String)firstTable.getValueAt(0, 1));

					arrayObj = Array.newInstance(clazz, length);

					int lengthA = Array.getLength(arrayObj);
					for(int i=0; i<lengthA; i++){
						String[] data = {arrayObj.getClass().getComponentType().toString(), Integer.toString(i)};
						arrayModel.addRow(data);
					}
				}

				constructorModel.setRowCount(0);
				Constructor<?>[] cons = clazz.getDeclaredConstructors();

				for(int i=0; i<cons.length; i++){
					Type[] t = cons[i].getGenericParameterTypes();
					String parameter ="";
					for(int j=0;j<t.length; j++){
						parameter += t[j].toString();
						if(j < t.length -1){
							parameter += ",";
						}
					}

					Type[] exc = cons[i].getGenericExceptionTypes();
					String excp ="";
					for(int j=0;j<exc.length; j++){
						excp += exc[j].toString();
						if(j < t.length -1){
							excp += ",";
						}
					}

					String[] data = {cons[i].getName() + " (" +parameter + ") throws "+excp};
					constructorModel.addRow(data);
				}

				validate();

				text.append(aryStr + " の配列生成に成功しました。");

			} catch (ClassNotFoundException e1) {
				text.append("配列生成に失敗しました。");
			}
		}

	}

	class ArrayToConstructorListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {

			if(controlList == 0){
				if(!isCreatingObject){
					controlList++;
					constructorModel.setRowCount(0);
					int[] sc = arrayTable.getSelectedRows();

					String aryStr = (String)arrayTable.getValueAt(sc[0], 0);
					Class<?> clazz = null;
					if(aryStr.startsWith("int")){
						clazz = int.class;
					}else if(aryStr.startsWith("char")){
						clazz = char.class;
					}else if(aryStr.startsWith("long")){
						clazz = long.class;
					}else if(aryStr.startsWith("double")){
						clazz = double.class;
					}else if(aryStr.startsWith("float")){
						clazz = float.class;
					}else if(aryStr.startsWith("short")){
						clazz = short.class;
					}else if(aryStr.startsWith("byte")){
						clazz = byte.class;
					}else if(aryStr.startsWith("boolean")){
						clazz = boolean.class;
					}else{
						try {
							if(aryStr.startsWith("class"))
								aryStr = aryStr.replaceAll("class ", "");
							clazz = Class.forName(aryStr);

						} catch (ClassNotFoundException e1) {
							text.append("配列の要素からコンストラクタを正しく呼び出せませんでした。");
						}
					}

					Constructor<?>[] cons = clazz.getDeclaredConstructors();

					for(int i=0; i<cons.length; i++){
						Type[] t = cons[i].getGenericParameterTypes();
						String parameter ="";
						for(int j=0;j<t.length; j++){
							parameter += t[j].toString();
							if(j < t.length -1){
								parameter += ",";
							}
						}

						Type[] exc = cons[i].getGenericExceptionTypes();
						String excp ="";
						for(int j=0;j<exc.length; j++){
							excp += exc[j].toString();
							if(j < t.length -1){
								excp += ",";
							}
						}

						String[] data = {cons[i].getName() + " (" +parameter + ") throws "+excp};
						constructorModel.addRow(data);
					}

					validate();

				}else{
					isCreatingObject = false;
				}
			}else{
				controlList = 0;
			}
		}

	}

	class CallConstructorListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			try {
				String aryStr = (String)firstTable.getValueAt(0, 0);

				constructorModel.setRowCount(0);
				cls = Class.forName(aryStr);

				Constructor<?>[] cons = cls.getDeclaredConstructors();

				for(int i=0; i<cons.length; i++){
					Type[] t = cons[i].getGenericParameterTypes();
					String parameter ="";
					for(int j=0;j<t.length; j++){
						parameter += t[j].toString();
						if(j < t.length -1){
							parameter += ",";
						}
					}

					Type[] exc = cons[i].getGenericExceptionTypes();
					String excp ="";
					for(int j=0;j<exc.length; j++){
						excp += exc[j].toString();
						if(j < t.length -1){
							excp += ",";
						}
					}
					String[] data = {cons[i].getName() + " (" +parameter + ") throws "+excp};
					constructorModel.addRow(data);

					}
				validate();
				text.append(aryStr+" のコンストラクタの呼び出しに成功しました。");

			} catch (ClassNotFoundException e1) {
				text.append("コンストラクタ呼び出しに失敗しました。(ClassNotFoundException)");
			} catch (NullPointerException e1) {
				text.append("コンストラクタ呼び出しに失敗しました。(NullPointerException)");
			} catch (Exception e1) {
				text.append("コンストラクタ呼び出しに失敗しました。(Exception)");
			}
		}

	}


	class ObjectInstanceListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			isCreatingObject = true;

			Object obj = null;
			String classname = "InterpretGui";

			try {
				int ii = constructorTable.getSelectedRow();
				String clsStr = ((String)constructorTable.getValueAt(ii,0));
				String clsName = clsStr.substring(0, clsStr.indexOf("(")-1);

				cls = Class.forName(clsName);

				if(!argsField.getText().equals("")){

					String[] argsString;

					if(argsField.getText().indexOf(",") != -1){
						argsString = argsField.getText().split(",");
					}else{
						argsString = new String[1];
						argsString[0] = argsField.getText();
					}

					Constructor<?> constructor;
					Class<?>[] args = new Class<?>[argsString.length];
					Object[] argsObj = new Object[argsString.length];

					for(int i=0; i<argsString.length; i++){
						if(argsString[i].startsWith("int")){
							args[i] = int.class;
							String intArgs = argsString[i].substring(4);
							Class wrapperClass = Class.forName("java.lang.Integer");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(intArgs);
							argsObj[i] =wrapperObj.getClass().getMethod("intValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("char")){
							args[i] = char.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Character");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("charValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("long")){
							args[i] = long.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Long");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("longValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("double")){
							args[i] = double.class;
							String a = argsString[i].substring(7);
							Class wrapperClass = Class.forName("java.lang.Double");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("doubleValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("float")){
							args[i] = float.class;
							String a = argsString[i].substring(6);
							Class wrapperClass = Class.forName("java.lang.Float");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("floatValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("short")){
							args[i] = short.class;
							String a = argsString[i].substring(6);
							Class wrapperClass = Class.forName("java.lang.Short");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("shortValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("byte")){
							args[i] = byte.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Byte");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("byteValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("boolean")){
							args[i] = boolean.class;
							String a = argsString[i].substring(8);
							Class wrapperClass = Class.forName("java.lang.Boolean");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("booleanValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("String")){
							args[i] = Class.forName("java.lang.String");
							String a = argsString[i].substring(7);
							argsObj[i] = args[i].getConstructor(String.class).newInstance(a);
						}else{
							if(argsString[i].startsWith("class"))
								argsString[i] = argsString[i].replaceAll("class ", "");
							args[i] = Class.forName(argsString[i]);
							String a = argsString[i].substring(argsString[i].indexOf(" "));
							argsObj[i] = args[i].getConstructor(String.class).newInstance(a);
						}
					}
						constructor = cls.getConstructor(args);
						constructor.setAccessible(true);
						obj = constructor.newInstance(argsObj);

				}else{
						obj = cls.newInstance();
						}

			} catch (SecurityException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":SecurityException");
			} catch (NoSuchMethodException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":NoSuchMethodException");
			} catch (IllegalArgumentException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":IllegalArgumentException");
			} catch (InvocationTargetException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":InvocationTargetException");
			} catch (InstantiationException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":InstantationException");
			} catch (IllegalAccessException e1){
				text.append("インスタンス生成に失敗しました。 "+classname+":IllegalAccessException");
			} catch (ClassNotFoundException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":ClassNotFoundException");
			} catch (ClassCastException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":ClassCastException");
			} catch (Exception e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":Exception");
			}

			try{
				if(!InstanceGui.isInstanceGuiShow){
					gui.setVisible(true);
				}
				gui.addObj(cls,obj);

				text.append("インスタンス生成に成功しました。");

			}catch(Exception e2){
				//処理済みなので何もしない。
			}

		}

	}

	class ArraytoInstanceListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			isCreatingObject = true;

			Object obj = null;
			String classname = "InterpretGui";
			int[] sc = null;

			try {
				int ii = constructorTable.getSelectedRow();
				String clsStr = ((String)constructorTable.getValueAt(ii,0));
				String clsName = clsStr.substring(0, clsStr.indexOf("(")-1);

				cls = Class.forName(clsName);

				if(!argsField.getText().equals("")){

					String[] argsString;

					if(argsField.getText().indexOf(",") != -1){
						argsString = argsField.getText().split(",");
					}else{
						argsString = new String[1];
						argsString[0] = argsField.getText();
					}

					Constructor<?> constructor;
					Class<?>[] args = new Class<?>[argsString.length];
					Object[] argsObj = new Object[argsString.length];

					for(int i=0; i<argsString.length; i++){
						if(argsString[i].startsWith("int")){
							args[i] = int.class;
							String intArgs = argsString[i].substring(4);
							Class wrapperClass = Class.forName("java.lang.Integer");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(intArgs);
							argsObj[i] =wrapperObj.getClass().getMethod("intValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("char")){
							args[i] = char.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Character");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("charValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("long")){
							args[i] = long.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Long");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("longValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("double")){
							args[i] = double.class;
							String a = argsString[i].substring(7);
							Class wrapperClass = Class.forName("java.lang.Double");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("doubleValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("float")){
							args[i] = float.class;
							String a = argsString[i].substring(6);
							Class wrapperClass = Class.forName("java.lang.Float");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("floatValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("short")){
							args[i] = short.class;
							String a = argsString[i].substring(6);
							Class wrapperClass = Class.forName("java.lang.Short");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("shortValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("byte")){
							args[i] = byte.class;
							String a = argsString[i].substring(5);
							Class wrapperClass = Class.forName("java.lang.Byte");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("byteValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("boolean")){
							args[i] = boolean.class;
							String a = argsString[i].substring(8);
							Class wrapperClass = Class.forName("java.lang.Boolean");
							Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(a);
							argsObj[i] =wrapperObj.getClass().getMethod("booleanValue", null ).invoke(wrapperObj, null);
						}else if(argsString[i].startsWith("String")){
							args[i] = Class.forName("java.lang.String");
							String a = argsString[i].substring(7);
							argsObj[i] = args[i].getConstructor(String.class).newInstance(a);
						}else{
							if(argsString[i].startsWith("class"))
								argsString[i] = argsString[i].replaceAll("class ", "");
							args[i] = Class.forName(argsString[i]);
							String a = argsString[i].substring(argsString[i].indexOf(" "));
							argsObj[i] = args[i].getConstructor(String.class).newInstance(a);
						}
					}
						constructor = cls.getConstructor(args);
						constructor.setAccessible(true);
						obj = constructor.newInstance(argsObj);

				}else{
						obj = cls.newInstance();
				}

				//配列の書き換え
				sc = arrayTable.getSelectedRows();
				Array.set(arrayObj, sc[0], obj);

			} catch (SecurityException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":SecurityException");
			} catch (NoSuchMethodException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":NoSuchMethodException");
			} catch (IllegalArgumentException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":IllegalArgumentException");
			} catch (InvocationTargetException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":InvocationTargetException");
			} catch (InstantiationException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":InstantationException");
			} catch (IllegalAccessException e1){
				text.append("インスタンス生成に失敗しました。 "+classname+":IllegalAccessException");
			} catch (ClassNotFoundException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":ClassNotFoundException");
			} catch (ClassCastException e1) {
				text.append("インスタンス生成に失敗しました。 "+classname+":ClassCastException");
			} catch (Exception e1) {
				e1.printStackTrace();
				text.append("インスタンス生成に失敗しました。 "+classname+":Exception");
			}

			try{
				if(!InstanceGui.isInstanceGuiShow){
					gui.setVisible(true);
				}
				gui.addObj(cls, Array.get(arrayObj, sc[0]), sc[0]);

				text.append("インスタンス生成に成功しました。");

			}catch(Exception e2){
				//処理済みなので何もしない。
			}

		}

	}


}