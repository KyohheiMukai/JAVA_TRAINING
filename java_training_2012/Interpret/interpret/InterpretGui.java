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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterpretGui extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Container contentPane;
	JTextField text1;
	JTextField methodParamField;
	JTextField constructorField;
	JTextField arrayField;
	JPanel firstPanel;
	JButton button1;
	JButton fieldSetButton;
	JButton callMethodButton;
	JButton constructorButton;
	JButton instanceButton;
	JTextField[] text2;
	JPanel fieldSetPanel;
	Field[] f;
	Method[] methods;
	Class<?> cls;
	JTable fieldSetTable;
	DefaultTableModel fieldSetmodel;
	JTable callMethodTable;
	DefaultTableModel callMethodModel;
	JTable arrayTable;
	DefaultTableModel arrayModel;
	JTable constructorTable;
	DefaultTableModel constructorModel;
	JTable firstTable;
	DefaultTableModel fistModel;
	JPanel callMethodPanel;
	JPanel arrayPanel;
	JPanel constructorPanel;

	JPanel bigPanel;
	ClassLoader loader = ClassLoader.getSystemClassLoader();

	private String[] createColumnNames = {"Type","Length"};
	private String[] arrayColumnNames = {"Type","Length"};
	private String[] fieldColumnNames = { "Field", "Value" };
	private String[] methodColumnNames = { "Method", "Return", "Parameter"};
	private String[] constructorColumnNames = {  "Parameter", "Exception"};

	InterpretGui(){

		setBounds(500,500,1200,700);
		setLocationRelativeTo(null);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbcPanel = new GridBagConstraints();

		firstPanel = new JPanel();
		fistModel = new DefaultTableModel(1,2);
		fistModel.setColumnIdentifiers(createColumnNames);
		firstTable = new JTable(fistModel);
		JScrollPane fistScrollpane = new JScrollPane(firstTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(fistScrollpane, gbcPanel);
		firstPanel.add(fistScrollpane);
		instanceButton = new JButton("CreateArray");
		instanceButton.addActionListener(new CreateArrayListener());
		instanceButton.setSize(120, 120);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(instanceButton, gbcPanel);
		firstPanel.add(instanceButton);
		firstPanel.setLayout(gbl);

		arrayPanel = new JPanel();
		arrayModel = new DefaultTableModel(0,2);
		arrayModel.setColumnIdentifiers(arrayColumnNames);
		arrayTable = new JTable(arrayModel);
		JScrollPane arrayScrollpane = new JScrollPane(arrayTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(arrayScrollpane, gbcPanel);
		arrayPanel.add(arrayScrollpane);
		constructorButton = new JButton("callConstructor");
		constructorButton.addActionListener(new ConstructorListener());
		constructorButton.setSize(120, 120);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(constructorButton, gbcPanel);
		arrayPanel.add(constructorButton);
		arrayPanel.setLayout(gbl);

		constructorPanel = new JPanel();
		constructorModel = new DefaultTableModel(50,2);
		constructorModel.setColumnIdentifiers(constructorColumnNames);
		constructorTable= new JTable(constructorModel);
		JScrollPane constructorScrollpane = new JScrollPane(constructorTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(constructorScrollpane, gbcPanel);
		constructorPanel.add(constructorScrollpane);
		constructorField = new JTextField(20);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(constructorField, gbcPanel);
		constructorPanel.add(constructorField);
		instanceButton = new JButton("newInstance");
		instanceButton.addActionListener(new ObjectInstanceListener());
		instanceButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(instanceButton, gbcPanel);
		constructorPanel.add(instanceButton);
		constructorPanel.setLayout(gbl);

		fieldSetPanel = new JPanel();
		fieldSetmodel = new DefaultTableModel(50,2);
		fieldSetmodel.setColumnIdentifiers(fieldColumnNames);
		fieldSetTable = new JTable(fieldSetmodel);
		JScrollPane fieldSetScrollpane = new JScrollPane(fieldSetTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(fieldSetScrollpane, gbcPanel);
		fieldSetPanel.add(fieldSetScrollpane);
		fieldSetButton = new JButton("FieldSet");
		fieldSetButton.addActionListener(new SetFieldListener());
		fieldSetButton.setSize(120, 120);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(fieldSetButton, gbcPanel);
		fieldSetPanel.add(fieldSetButton);
		fieldSetPanel.setLayout(gbl);


		callMethodPanel = new JPanel();
		callMethodModel = new DefaultTableModel(50,3);
		callMethodModel.setColumnIdentifiers(methodColumnNames);
		callMethodTable= new JTable(callMethodModel);
		JScrollPane callMethodScrollpane = new JScrollPane(callMethodTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(callMethodScrollpane, gbcPanel);
		callMethodPanel.add(callMethodScrollpane);
		methodParamField = new JTextField(20);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(methodParamField, gbcPanel);
		callMethodPanel.add(methodParamField);
		callMethodButton = new JButton("Call Method");
		callMethodButton.addActionListener(new CallMethodListener());
		callMethodButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(callMethodButton, gbcPanel);
		callMethodPanel.add(callMethodButton);
		callMethodPanel.setLayout(gbl);

		bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(3,2));
		bigPanel.add(firstPanel);
		bigPanel.add(arrayPanel);
		bigPanel.add(constructorPanel);
		bigPanel.add(fieldSetPanel);
		bigPanel.add(callMethodPanel);

		JScrollPane bigScrollpane = new JScrollPane(bigPanel);
		bigScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bigScrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(bigScrollpane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	class CreateArrayListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj;
			try {
				String aryStr = (String)firstTable.getValueAt(0, 0);
				int length = Integer.parseInt((String)firstTable.getValueAt(0, 1));

//				if(aryStr.equals("int")){
//					args[i] = int.class;
//					argsObj[i] = Integer.parseInt(aryStr);
//				}else if(aryStr.equals("char")){
//					args[i] = char.class;
//				}else if(aryStr.equals("long")){
//					args[i] = long.class;
//					argsObj[i] = Long.parseLong(aryStr);
//				}else if(aryStr.equals("double")){
//					args[i] = double.class;
//					argsObj[i] = Double.parseDouble(aryStr);
//				}else if(aryStr.equals("float")){
//					args[i] = float.class;
//					argsObj[i] = Float.parseFloat(aryStr);
//				}else if(aryStr.equals("short")){
//					args[i] = short.class;
//					argsObj[i] = Short.parseShort(aryStr);
//				}else if(aryStr.equals("byte")){
//					args[i] = byte.class;
//					argsObj[i] = Byte.parseByte(aryStr);
//				}else if(aryStr.equals("boolean")){
//					args[i] = boolean.class;
//					argsObj[i] = Boolean.parseBoolean(aryStr);
//				}else{
				Class<?> clazz = Class.forName(aryStr);
				obj = Array.newInstance(clazz, length);
//				}
				String[] data = {obj.getClass().getComponentType().toString(), Integer.toString(length)};
				arrayModel.addRow(data);
				validate();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		}

	}

	class ConstructorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cls = null;
			try {
				int ii = arrayTable.getSelectedRow();
				if(((String)arrayTable.getValueAt(ii,0)).startsWith("class")){
					String clsName = ((String)arrayTable.getValueAt(ii,0)).replaceAll("class ", "");
					cls = Class.forName(clsName);
				}

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
					constructorModel.setValueAt(parameter, i, 0);

					Type[] exc = cons[i].getGenericExceptionTypes();
					String excp ="";
					for(int j=0;j<exc.length; j++){
						excp += exc[j].toString();
						if(j < t.length -1){
							excp += ",";
						}
					}
					constructorModel.setValueAt(excp, i, 1);

				}

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			validate();

		}

	}

	class ObjectInstanceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int ii = constructorTable.getSelectedRow();
			String clsName = ((String)constructorTable.getValueAt(ii,0));
			try {
				Object obj = null;

				if(constructorField.getText() != null){
					String[] argsString = clsName.split(",");
					Constructor<?> constructor;
					Class<?>[] args = new Class[argsString.length];
					Object[] argsObj = new Object[argsString.length];
					for(int i=0; i<argsString.length; i++){
						if(argsString[i].equals("int") || argsString[i].equals("java.lang.Integer")){
							args[i] = int.class;
							argsObj[i] = Integer.parseInt(argsString[i]);
						}else if(argsString[i].equals("char") || argsString[i].equals("java.lang.Character")){
							args[i] = char.class;
						}else if(argsString[i].equals("long") || argsString[i].equals("java.lang.Long")){
							args[i] = long.class;
							argsObj[i] = Long.parseLong(argsString[i]);
						}else if(argsString[i].equals("double") || argsString[i].equals("java.lang.Double")){
							args[i] = double.class;
							argsObj[i] = Double.parseDouble(argsString[i]);
						}else if(argsString[i].equals("float") || argsString[i].equals("java.lang.Float")){
							args[i] = float.class;
							argsObj[i] = Float.parseFloat(argsString[i]);
						}else if(argsString[i].equals("short") || argsString[i].equals("java.lang.Short")){
							args[i] = short.class;
							argsObj[i] = Short.parseShort(argsString[i]);
						}else if(argsString[i].equals("byte") || argsString[i].equals("java.lang.Byte")){
							args[i] = byte.class;
							argsObj[i] = Byte.parseByte(argsString[i]);
						}else if(argsString[i].equals("boolean") || argsString[i].equals("java.lang.Boolean")){
							args[i] = boolean.class;
							argsObj[i] = Boolean.parseBoolean(argsString[i]);
						}else{
							if(argsString[i].startsWith("class"))
								argsString[i] = argsString[i].replaceAll("class ", "");
							args[i] = Class.forName(argsString[i]);
							argsObj[i] = args[i].newInstance();
						}

					}
					try {
						constructor = cls.getConstructor(args);
						obj = constructor.newInstance((Object)argsObj);
					} catch (SecurityException e1) {
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						e1.printStackTrace();
					}

			}else{
				obj = (Class<?>)cls.newInstance();
			}

			f = cls.getFields();
			methods = cls.getMethods();

			} catch (InstantiationException e2) {
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				e2.printStackTrace();
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			}

			for(int i=0; i<f.length; i++){
				fieldSetmodel.setValueAt(f[i].toString(), i, 0);
				callMethodModel.setValueAt(methods[i].getName(), i, 0);
				callMethodModel.setValueAt(methods[i].getGenericReturnType().toString(), i, 1);

				Type[] methodParameterType = methods[i].getGenericParameterTypes();
				String parameter ="";
				for(int j=0;j<methods[i].getGenericParameterTypes().length; j++){
					parameter += methodParameterType[j].toString();
					if(j < methods[i].getGenericParameterTypes().length -1){
						parameter += ",";
					}
				}
				callMethodModel.setValueAt(parameter, i, 2);
			    try {
					fieldSetmodel.setValueAt(f[i].get(cls), i, 1);
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
					//TODO 警告出したい。。。
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
					//TODO 警告出したい。。。
				}
			}
			validate();

		}

	}

	class SetFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(f != null){
				for(int i=0; i<f.length; i++){
					try {
						if (!Modifier.isFinal(f[i].getModifiers())) {
							f[i].setAccessible(true);
					    	f[i].set(cls, fieldSetmodel.getValueAt(i, 1));
						}
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					}
				}
			}else{
				//TODO 警告出したい。。。
			}
		}

	}

	class CallMethodListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			/* 引数なししかできません。*/
			if(methods != null){
				int ii = callMethodTable.getSelectedRow();
				String s1 = (String)callMethodTable.getValueAt(ii,0);

				try {
					if((String)callMethodTable.getValueAt(ii,1) != null){
						String[] argsString = ((String)callMethodTable.getValueAt(ii,1)).split(",");
						Class<?>[] args = new Class[argsString.length];
						Object[] argsObj = new Object[argsString.length];
						for(int i=0; i<argsString.length; i++){
							if(argsString[i].equals("int") || argsString[i].equals("java.lang.Integer")){
								args[i] = int.class;
								argsObj[i] = new Integer(argsString[i]);
							}else if(argsString[i].equals("char") || argsString[i].equals("java.lang.Character")){
								args[i] = char.class;
							}else if(argsString[i].equals("long") || argsString[i].equals("java.lang.Long")){
								args[i] = long.class;
								argsObj[i] = new Long(argsString[i]);
							}else if(argsString[i].equals("double") || argsString[i].equals("java.lang.Double")){
								args[i] = double.class;
								argsObj[i] = new Double(argsString[i]);
							}else if(argsString[i].equals("float") || argsString[i].equals("java.lang.Float")){
								args[i] = float.class;
								argsObj[i] = new Float(argsString[i]);
							}else if(argsString[i].equals("short") || argsString[i].equals("java.lang.Short")){
								args[i] = short.class;
								argsObj[i] = new Short(argsString[i]);
							}else if(argsString[i].equals("byte") || argsString[i].equals("java.lang.Byte")){
								args[i] = byte.class;
								argsObj[i] = new Byte(argsString[i]);
							}else if(argsString[i].equals("boolean") || argsString[i].equals("java.lang.Boolean")){
								args[i] = boolean.class;
								argsObj[i] = new Boolean(argsString[i]);
							}else{
								args[i] = Class.forName(argsString[i]);
								argsObj[i] = args[i].newInstance();
							}
						}

						Method reflectionMethod = cls.getMethod(s1, args);
						reflectionMethod.invoke(cls, argsObj);

					}else{
						Method reflectionMethod = cls.getMethod(s1);
						reflectionMethod.invoke(cls);
					}

				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				}

			}else{
				//TODO 警告出したい。。。
			}
		}
	}


}