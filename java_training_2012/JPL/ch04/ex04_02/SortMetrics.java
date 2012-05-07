package ch04.ex04_02;

public class SortMetrics implements Cloneable {

	public long probeCnt;
	public long compareCnt;
	public long swapCnt;

	public void init() {
		probeCnt=0;
		compareCnt=0;
		swapCnt=0;

	}

	public String toString(){
		return probeCnt + " probes " + compareCnt + " compares " + swapCnt + " swaps";
	}

	public SortMetrics clone(){
		try {
			return (SortMetrics)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("複製失敗");
			throw new InternalError(e.toString());
		}
	}

}
