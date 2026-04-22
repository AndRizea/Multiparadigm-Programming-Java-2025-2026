package csie.ase.ro.synced;

public class SyncedThread implements Runnable {
	private static int a = 0;
	private static int b = 0;
	private static Object lock = new Object();

	@Override
	public void run() {
		System.out.println("Hello from the synced thread");

		synchronized (lock) {
			for (int i = 0; i < 3; i++) {
				System.out.println(String.format("a=%d, b=%d", a, b));
				a++;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				b++;
			}
		}


	}
	
	public synchronized void method() {
		// incrementing a and b
	}

}
