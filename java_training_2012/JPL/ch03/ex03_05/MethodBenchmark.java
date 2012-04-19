package ch03.ex03_05;

public class MethodBenchmark extends Benchmark {

	int c;

	@Override
	void benchmark(int c) {
		this.c = c;

	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new MethodBenchmark().repeat(count);

		System.out.println(count + "method in "+ time + "nanoseconds");
	}

}
