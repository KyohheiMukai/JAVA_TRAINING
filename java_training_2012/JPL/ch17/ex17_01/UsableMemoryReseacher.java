package ch17.ex17_01;

import ch16.ex16_05.ClassContents;

public class UsableMemoryReseacher {

	public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime();
		System.out.println("TotalMemory:"+rt.totalMemory());
		System.out.println("FreeMemory:"+rt.freeMemory());
		System.out.println("----------Create Instances-------------------");
		for(int i=0; i<10000; i++){
			ClassContents a = new ClassContents();
			ClassContents b = new ClassContents();
			ClassContents c = new ClassContents();
			ClassContents d = new ClassContents();
			ClassContents e = new ClassContents();
			ClassContents f = new ClassContents();
			ClassContents g = new ClassContents();
			ClassContents h = new ClassContents();
			ClassContents ii = new ClassContents();
			ClassContents j = new ClassContents();
			ClassContents k = new ClassContents();
		}
		System.out.println("FreeMemory:"+rt.freeMemory());
		System.out.println("----------Call gc----------------------------");
		rt.gc();
		System.out.println("FreeMemory:"+rt.freeMemory());

	}

}
