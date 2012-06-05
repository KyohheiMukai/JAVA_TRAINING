package ch10.ex10_04;

public class PascalsTriangle {

	private int[][] p;
	int num = 12;

	PascalsTriangle(){
		p = new int[num][num];
	}

	/**
	 * この場合はi<numが必ずtrueになるので、
	 * do-while文にて書き直す必要はない
	 */
	void calc(){
		int i=0,j=0;
		while(i<num){
			p[i][0] = 1;
			while(j<=i){
				p[i][j] = (j==i ? 1 : p[i-1][j] + p[i][j-1]);
				j++;
			}
			i++;
		}
	}

	public void show(){
		int i=0,j=0;
		while(i<num){
			while(j<=i){
				System.out.print(p[i][j] + " ");
				j++;
			}
			System.out.println();
			i++;
		}
//		for(int i=0; i<num; i++){
//			for(int j=0; j<=i; j++){
//				System.out.print(p[i][j] + " ");
//			}
//			System.out.println();
//		}
	}


	public static void main(String[] args) {
		PascalsTriangle pascal = new PascalsTriangle();
		pascal.calc();
		pascal.show();
	}

}