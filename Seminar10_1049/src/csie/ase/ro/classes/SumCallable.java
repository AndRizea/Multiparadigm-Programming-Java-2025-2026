package csie.ase.ro.classes;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Long> {
	private int[] array;
	private int startIndex;
	private int stopIndex;

	public SumCallable(int[] array, int startIndex, int stopIndex) {
		this.array = array;
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = startIndex; i < stopIndex; i++) {
			sum += array[i];
		}

		return sum;
	}

}
