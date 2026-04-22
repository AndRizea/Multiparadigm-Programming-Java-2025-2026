package csie.ase.ro.main;

import csie.ase.ro.synced.SyncedThread;
import csie.ase.ro.unsynced.UnsyncedThread;

public class Main {

	public static void main(String[] args) {

		UnsyncedThread unsyncedThread1 = new UnsyncedThread();
		// unsyncedThread1.run(); -> it will not start another thread
		unsyncedThread1.start();

		UnsyncedThread unsyncedThread2 = new UnsyncedThread();
		unsyncedThread2.start();

		SyncedThread syncedThread1 = new SyncedThread();
		SyncedThread syncedThread2 = new SyncedThread();

		new Thread(syncedThread1).start();
		new Thread(syncedThread2).start();

		Runnable r = () -> System.out.println("Processing starts from lambda function");
		new Thread(r).start();

		Runnable r2 = () -> {
			int x = 5 / 0;
		};

		try {
			new Thread(r2).start();
		} catch (Exception e) {
			System.out.println("Exception caught!"); // never called
		}

		Runnable r3 = () -> {
			try {
				int x = 5 / 0;
			} catch (Exception e) {
				System.out.println("Exception caught!");
			}
		};

		new Thread(r3).start();
	}

}
