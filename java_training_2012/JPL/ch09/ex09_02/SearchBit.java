package ch09.ex09_02;

public class SearchBit {

	public static int getBit(Integer target){

		int cnt=0;
		for(int i=0; i<Integer.SIZE; i++){
			cnt += (target & 1);
			target = target>>>1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Integer i = 1001;
		System.out.println(i+"で1となっているbit数は"+SearchBit.getBit(i));
	}

}
