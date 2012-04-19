package ch01.ex01_15;

public class SimpleLookup implements Lookup {

	private String[] names;
	private Object[] values;

	@Override
	public Object find(String name) {
		for(int i=0;i <names.length; i++){
			if(names[i].equals(name)){
				return values[i];
			}
		}
		return null;
	}

	/**
	 * @param 配列？
	 * @return 配列？？
	 */
	@Override
	public void add(String str){

	}

	@Override
	public void remove(String str) {

	}

}
