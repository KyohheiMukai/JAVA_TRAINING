package ch22.ex22_01;

public class FormattArray {

	public static void showArray(double[] d, int row){

		for(int i=0; i<d.length; i++){
			System.out.printf("%1$."+row+"g",d[i]);
			System.out.println();
		}
	}


	public static void main(String[] args) {
		double[] d = {1.3, 2.3333, 1.444123};
		int row = 5;
		showArray(d,row);
	}

}
