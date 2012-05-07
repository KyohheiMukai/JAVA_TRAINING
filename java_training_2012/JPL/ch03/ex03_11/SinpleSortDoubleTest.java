package ch03.ex03_11;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinpleSortDoubleTest {

	double[] testData = {0,3,7,9,3.17};
	final double[] SORT_DATA = {0,3,3.17,7,9,17};

	@Test
	public void testDoSort() {
		SortDouble bSort = new SinpleSortDouble();
		SortMetrics metrics = bSort.sort(testData);
		System.out.println(metrics);
		assertTrue(checkSort());
	}

	private boolean checkSort(){
		for(int i=0; i<testData.length; i++){
			if(testData[i]!=SORT_DATA[i])
				return false;
		}
		return true;
	}

}
