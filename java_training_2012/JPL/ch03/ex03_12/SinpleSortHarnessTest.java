package ch03.ex03_12;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinpleSortHarnessTest {

	String[] testData = {"0","3","7","9","3.17"};
	final String[] SORT_DATA = {"0","3","3.17","7","9","17"};

	@Test
	public void testDoSort() {
		SortHarness bSort = new SimpleSortHarness();
		SortMetrics metrics = bSort.sort(testData);
		System.out.println(metrics);
		assertTrue(checkSort());
	}

	private boolean checkSort(){
		for(int i=0; i<testData.length; i++){
			if(testData[i].equals(SORT_DATA[i]))
				return false;
		}
		return true;
	}

}
