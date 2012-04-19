package ch01.ex01_08;


public class PointTest {

	Point lowerLeft = new Point();
	Point upperRight = new Point();
	Point middlePoint = new Point();

	public void setUp(){
		lowerLeft = new Point();
		upperRight = new Point();
		middlePoint = new Point();

		lowerLeft.x = 0.0;
		lowerLeft.y = 0.0;

		upperRight.x = 1280.0;
		upperRight.y = 1024.0;

		middlePoint.x = 640.0;
		middlePoint.y = 512.0;

	}

	public void testSetOtherPoint() {

		System.out.println("lowerLeft.x = "+lowerLeft.x);
		System.out.println("lowerLeft.y = "+lowerLeft.y);

		lowerLeft.setOtherPoint(middlePoint);

		System.out.println("lowerLeft.x = "+lowerLeft.x);
		System.out.println("lowerLeft.y = "+lowerLeft.y);
	}

}
