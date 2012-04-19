package ch03.ex03_02;

public class X {

	protected int xMask = 0x00ff;
	protected int fullMask;

	public X(){
		xPrint();
		fullMask = xMask;
		xPrint();
	}

	public int mask(int orig){
		return (orig & fullMask);
	}

	public void xPrint(){
		System.out.printf("xMask: %x,fullMask: %x",xMask,fullMask);
		System.out.println();
	}
}
