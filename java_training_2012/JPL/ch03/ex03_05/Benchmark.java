package ch03.ex03_05;

public abstract class Benchmark {

	abstract void benchmark(int c);

	public final long repeat(int count){
		long start = System.nanoTime();
		for(int i=0; i<count; i++){
			benchmark(count);
		}
		return System.nanoTime() - start;
	}

}
