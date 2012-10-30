package interpret;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class InstanceGui extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Container contentPane;
	JTextField text1;
	JTextField methodParamField;
	JButton fieldSetButton;
	JButton invokeButton;
	JTextField[] text2;
	JPanel fieldSetPanel;
	Class<?> cls;
	Field[] f;
	Method[] methods;
	JTable fieldSetTable;
	DefaultTableModel fieldSetModel;
	JTable callMethodTable;
	DefaultTableModel callMethodModel;
	JTable instanceTable;
	DefaultTableModel instanceModel;
	JPanel callMethodPanel;
	JPanel instancePanel;
	TextFrame text;

	String[] comboMethod = {};
	private JComboBox cbMethod = new JComboBox(comboMethod);

	JPanel bigPanel;
	InterpretGui gui;
	ClassLoader loader = ClassLoader.getSystemClassLoader();

	static boolean isInstanceGuiShow = false;
	ArrayList<Class<?>> arrayList = new ArrayList<Class<?>>();
	ArrayList<Object> objList = new ArrayList<Object>();
	Object currentObj = null;

	private String[] fieldColumnNames = { "Field", "Value" };
	private String[] instanceColumnNames = {  "Number","Instance"};

	private JTextField fieldSetField;

	InstanceGui(TextFrame text){

		setTitle("Instance");
		this.text = text;
		setBounds(800,800,700,700);
		setLocationRelativeTo(null);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbcPanel = new GridBagConstraints();

		instancePanel = new JPanel();
		instanceModel = new DefaultTableModel(0,2);
		instanceModel.setColumnIdentifiers(instanceColumnNames);
		instanceTable= new JTable(instanceModel);
		instanceTable.getSelectionModel().addListSelectionListener(new ChoiceInstanceListener());
		JScrollPane instanceScrollpane = new JScrollPane(instanceTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(instanceScrollpane, gbcPanel);
		instancePanel.add(instanceScrollpane);
		instancePanel.setLayout(gbl);

		fieldSetPanel = new JPanel();
		fieldSetModel = new DefaultTableModel(0,2);
		fieldSetModel.setColumnIdentifiers(fieldColumnNames);
		fieldSetTable = new JTable(fieldSetModel);
		JScrollPane fieldSetScrollpane = new JScrollPane(fieldSetTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(fieldSetScrollpane, gbcPanel);
		fieldSetPanel.add(fieldSetScrollpane);
		fieldSetField = new JTextField(20);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(fieldSetField, gbcPanel);
		fieldSetPanel.add(fieldSetField);
		fieldSetButton = new JButton("FieldSet");
		fieldSetButton.addActionListener(new SetFieldListener());
		fieldSetButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(fieldSetButton, gbcPanel);
		fieldSetPanel.add(fieldSetButton);
		fieldSetPanel.setLayout(gbl);

		callMethodPanel = new JPanel();
//		callMethodModel = new DefaultTableModel(0,3);
//		callMethodModel.setColumnIdentifiers(methodColumnNames);
//		callMethodTable= new JTable(callMethodModel);
//		JScrollPane callMethodScrollpane = new JScrollPane(callMethodTable);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbl.setConstraints(cbMethod, gbcPanel);
		callMethodPanel.add(cbMethod);
//		gbl.setConstraints(callMethodScrollpane, gbcPanel);
//		callMethodPanel.add(callMethodScrollpane);
		methodParamField = new JTextField(20);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbl.setConstraints(methodParamField, gbcPanel);
		callMethodPanel.add(methodParamField);
		invokeButton = new JButton("Call Method");
		invokeButton.addActionListener(new InvokeMethodListener());
		invokeButton.setSize(120, 120);
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbl.setConstraints(invokeButton, gbcPanel);
		callMethodPanel.add(invokeButton);
		callMethodPanel.setLayout(gbl);

		bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(2,3));
		bigPanel.add(instancePanel);
		bigPanel.add(fieldSetPanel);
		bigPanel.add(callMethodPanel);

		JScrollPane bigScrollpane = new JScrollPane(bigPanel);
		bigScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bigScrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(bigScrollpane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void addObj(Class<?> cls, Object obj){
		arrayList.add(cls);
		objList.add(obj);
		String objStr = cls.toString();
		if(objStr.startsWith("class"))
			objStr = objStr.replaceAll("class ", "");
		String[] str = {"obj"+Integer.toString(arrayList.size()-1), objStr};
		instanceModel.addRow(str);
		validate();
	}

	public void addObj(Class<?> cls, Object obj, int ary){
		arrayList.add(cls);
		objList.add(obj);
		String objStr = cls.toString() + "[" +ary+"]";
		if(objStr.startsWith("class"))
			objStr = objStr.replaceAll("class ", "");
		String[] str = {"obj"+Integer.toString(arrayList.size()-1), objStr};
		instanceModel.addRow(str);
		validate();
	}

	class ChoiceInstanceListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {

			fieldSetModel.setRowCount(0);

			int[] sc = instanceTable.getSelectedRows();
			cls = arrayList.get(sc[0]);
			currentObj = objList.get(sc[0]);

			f = cls.getDeclaredFields();
//			methods = cls.getDeclaredMethods();

			@SuppressWarnings("rawtypes")
			Class tempCls = cls;
			List<Method> methodsList = new ArrayList<Method>();
			Method[] tempMethods = null;
			tempMethods = cls.getDeclaredMethods();
			for(int i=0; i<tempMethods.length; i++){
				methodsList.add(tempMethods[i]);
			}
			tempMethods = null;
			while(tempCls.getSuperclass() != null){
				tempCls = tempCls.getSuperclass();
				tempMethods = tempCls.getDeclaredMethods();
				for(int i=0; i<tempMethods.length; i++){
//					if(methodsList.contains(tempMethods[i])){
//						System.out.println(tempMethods[i].toGenericString() + " " + tempCls.getName());
						methodsList.add(tempMethods[i]);
//					}
				}
				System.out.println();
			}
			methods = (Method[])methodsList.toArray(new Method[0]);

			try {
			    	for(int i=0; i<f.length; i++){
			    		f[i].setAccessible(true);
			    		String value;
			    		if(f[i].get(currentObj) ==null)
			    			value = "null";
			    		else
			    			value = f[i].get(currentObj).toString();

						String[] fieldSetStrings = {f[i].toString(), value};
						fieldSetModel.addRow(fieldSetStrings);
			    	}

					String[] list = new String[methods.length];
					for(int ii = 0; ii < methods.length; ii++){
			    		methods[ii].setAccessible(true);
						Method m = methods[ii];
						m.setAccessible(true);

						int mod = m.getModifiers();

						list[ii] = "";

						if (Modifier.isPrivate(mod)) {
							list[ii] += "private ";
						}
						if (Modifier.isProtected(mod)) {
							list[ii] += "protected ";
						}
						if (Modifier.isPublic(mod)) {
							list[ii] += "public ";
						}

						if (Modifier.isStatic(mod)) {
							list[ii] += "static ";
						}

						if (Modifier.isFinal(mod)) {
							list[ii] += "final ";
						}

						list[ii] += m.getGenericReturnType().toString() + "  " +m.getName() + "(";
						Class<?>[] params = m.getParameterTypes();
						if(params == null || params.length == 0){

						}else{
							for(int j = 0 ; j < params.length; j++){
								if(j != 0)list[ii]+= ",";
								list[ii] += params[j].getCanonicalName();
							}
						}
						list[ii] += ")";
						}

						String[] sorted  = new String[list.length];
						List<String> array = new ArrayList<String>();
						for(int i = 0; i < list.length; i++){
							array.add(list[i]);
						}
						Collections.sort(array);
						int iii= 0;
						for (String string : array) {
							sorted[iii] = string;
							iii++;
						}

					comboMethod = sorted;
					cbMethod.removeAllItems();
					for (int i = 0; i < comboMethod.length; i++) {
						cbMethod.addItem(sorted[i]);
					}
					cbMethod.setSelectedIndex(0);

				} catch (IllegalArgumentException e1) {
					text.append("インスタンス選択に失敗しました。 :IllegalArgumentException");
				} catch (IllegalAccessException e1) {
					text.append("インスタンス選択に失敗しました。 :IllegalAccessException");
				} catch (Exception e1) {
					text.append("インスタンス選択に失敗しました。 :Exception");
				}

			validate();
		}


	}

	class SetFieldListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String value = fieldSetField.getText();
			int[] sc = fieldSetTable.getSelectedRows();

			if(!value.equals("")){
				Field choiceField = f[sc[0]];
				choiceField.setAccessible(true);
				try {
					if(value.startsWith("int")){
						value = value.substring(4);
						choiceField.setInt(currentObj, Integer.parseInt(value));
					}else if(value.startsWith("char")){
						value = value.substring(5);
						choiceField.setChar(currentObj, value.charAt(0));
					}else if(value.startsWith("long")){
						value = value.substring(5);
						choiceField.setLong(currentObj, Long.parseLong(value));
					}else if(value.startsWith("double")){
						value = value.substring(7);
						choiceField.setDouble(currentObj, Double.parseDouble(value));
					}else if(value.startsWith("float")){
						value = value.substring(6);
						choiceField.setFloat(currentObj, Float.parseFloat(value));
					}else if(value.startsWith("short")){
						value = value.substring(6);
						choiceField.setShort(currentObj, Short.parseShort(value));
					}else if(value.startsWith("byte")){
						value = value.substring(5);
						choiceField.setByte(currentObj, Byte.parseByte(value));
					}else if(value.startsWith("boolean")){
						value = value.substring(8);
						choiceField.setBoolean(currentObj, Boolean.parseBoolean(value));
					}else if(value.startsWith("String")){
						value = value.substring(7);
						choiceField.set(currentObj, value);
					}else{
						choiceField.set(currentObj, Class.forName(value));
					}

					fieldSetModel.setRowCount(0);
					f = currentObj.getClass().getDeclaredFields();
					for(int i=0; i<f.length; i++){
						f[i].setAccessible(true);
						String valueStr;
			    		if(f[i].get(currentObj) ==null)
			    			valueStr = "null";
			    		else
			    			valueStr = f[i].get(currentObj).toString();
						String[] fieldSetStrings = {f[i].toString(), valueStr};
						fieldSetModel.addRow(fieldSetStrings);
			    	}
					validate();

					text.append("フィールド設定に成功しました");

				} catch (IllegalArgumentException e1) {
					text.append("フィールド設定に失敗しました(IllegalArgumentException)");
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					text.append("フィールド設定に失敗しました(IllegalAccessException)");
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					text.append("フィールド設定に失敗しました(ClassNotFoundException)");
				}
				validate();
			}else{
				text.append("フィールド値を入力してください");
			}
		}

	}

	class InvokeMethodListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(methods != null){

				String methodName = (String)cbMethod.getSelectedItem();
				int met = methodName.indexOf("  ");
				int c = methodName.indexOf("(");
				int end = methodName.indexOf(")");
				String m = methodName.substring(met+2,c);
				System.out.println(m);

				Object returnObject = null;

				try {
					if(end-c > 1){
						String[] argsString = methodParamField.getText().split(",");
						Class<?>[] args = new Class[argsString.length];
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
							}else if(argsString[i].startsWith("[obj")){
								int en = argsString[i].indexOf("]");
								args[i] = arrayList.get(Integer.parseInt(argsString[i].substring(4, en)));
								argsObj[i] = objList.get(Integer.parseInt(argsString[i].substring(4, en)));
							}else{
								if(argsString[i].startsWith("class"))
									argsString[i] = argsString[i].replaceAll("class ", "");
								args[i] = Class.forName(argsString[i]);
								String a = argsString[i].substring(argsString[i].indexOf(" "));
								argsObj[i] = args[i].getConstructor(String.class).newInstance(a);
							}
						}

						Method reflectionMethod = currentObj.getClass().getMethod(m, args);
						reflectionMethod.setAccessible(true);
						returnObject = reflectionMethod.invoke(currentObj, argsObj);

					}else{
						Method reflectionMethod = cls.getMethod(m);
						reflectionMethod.setAccessible(true);
						returnObject = reflectionMethod.invoke(currentObj);
					}

					if(returnObject != null)
						text.append(returnObject.toString());

					fieldSetModel.setRowCount(0);
					f = currentObj.getClass().getDeclaredFields();
					for(int i=0; i<f.length; i++){
						f[i].setAccessible(true);
						String valueStr;
			    		if(f[i].get(currentObj) ==null)
			    			valueStr = "null";
			    		else
			    			valueStr = f[i].get(currentObj).toString();
						String[] fieldSetStrings = {f[i].toString(), valueStr};
						fieldSetModel.addRow(fieldSetStrings);
			    	}


					validate();

				}catch (Exception e1){
					text.append(""+ e1.getCause()+"");
				}
//				} catch (SecurityException e1) {
//					text.append("メソッド呼び出しに失敗しました(SecurityException)");
//				} catch (NoSuchMethodException e1) {
//					text.append("メソッド呼び出しに失敗しました(NoSuchMethodException)");
//				} catch (IllegalArgumentException e1) {
//					text.append("メソッド呼び出しに失敗しました(IllegalArgumentException)");
//				} catch (IllegalAccessException e1) {
//					text.append("メソッド呼び出しに失敗しました(IllegalAccessException)");
//				} catch (InvocationTargetException e1) {
//					text.append("メソッド呼び出しに失敗しました("+ e1.getCause()+")");
//				} catch (ClassNotFoundException e1) {
//					text.append("メソッド呼び出しに失敗しました(ClassNotFoundException)");
//				} catch (InstantiationException e1) {
//					text.append("メソッド呼び出しに失敗しました(InstantiationException)");
//				}
			}else{
				text.append("もう一度やり直してください。");
			}
		}
	}


}