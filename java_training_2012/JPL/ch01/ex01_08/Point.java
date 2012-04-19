package ch01.ex01_08;

public class Point {

	public double x, y;

	public void clear(){
		this.x = 0.0;
		this.y = 0.0;
	}

	public double distance(Point that){
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}

	public void move(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setOtherPoint(Point that){
		this.x = that.x;
		this.y = that.y;
	}

}
