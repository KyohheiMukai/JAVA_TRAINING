package ch02.ex02_04;

public class Vehicle {
	public int speed;
	public double angle;
	public String owner;
	public int id;

	/**
	 * いつもがいつも次のIDを示すとは限らないため、
	 * finalにするべきではない
	 */
	public static int nextNo =0;
}
