package ch01.ex01_15;

interface Lookup {

	/**
	 * nameと関連付けされた値を返す。
	 * なければnullを返す。
	 */

	Object find(String name);
	void add(String str);
	void remove(String str);

}
