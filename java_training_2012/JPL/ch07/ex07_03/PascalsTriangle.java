package ch07.ex07_03;

public class PascalsTriangle {

	private int[][] p;
	int num = 12;

	PascalsTriangle(){
		p = new int[num][num];
	}

	void calc(){
		for(int i=0; i<num; i++){
			p[i][0] = 1;
			for(int j=1; j<=i; j++){

				if(j==i)
					p[i][j] = 1;
				else{
					p[i][j] = p[i-1][j] + p[i][j-1];
				}
			}
		}

	}

	public void show(){
		for(int i=0; i<num; i++){
			for(int j=0; j<=i; j++){
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		PascalsTriangle pascal = new PascalsTriangle();
		pascal.calc();
		pascal.show();
	}

}
