package csie.ase.ro.classes;

public class SumThread extends Thread {
	private int[] array;
	private int startIndex;
	private int stopIndex;
	private long sum = 0;

	public SumThread(int[] array, int startIndex, int stopIndex) {
		this.array = array;
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public void run() {
		for (int i = startIndex; i < stopIndex; i++) {
			sum += array[i];
		}
	}

}
