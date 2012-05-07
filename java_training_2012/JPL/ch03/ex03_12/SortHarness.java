package ch03.ex03_12;

public abstract class SortHarness {

	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(Object[] data){
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength(){
		return values.length;
	}

	protected final Object probe(int i){
		curMetrics.probeCnt++;
		return values[i];
	}

	@SuppressWarnings("unchecked")
	protected final int compare(int i, int j){
		curMetrics.compareCnt++;
		@SuppressWarnings("rawtypes")
		Comparable obj1 = (Comparable)values[i];
		@SuppressWarnings("rawtypes")
		Comparable obj2 = (Comparable)values[j];

		if(obj1.equals(obj2))
			return 0;
		else
			return (obj1.compareTo(obj2)==0 ? -1 : 1);

	}

	protected final void swap(int i, int j){
		curMetrics.swapCnt++;
		Object temp = values[i];
		values[i] = values[j];
		values[j] = temp;

	}

	protected abstract void doSort();


}
