package csie.ase.ro.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import csie.ase.ro.classes.MathModule;
import csie.ase.ro.classes.SumCallable;
import csie.ase.ro.classes.SumThread;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[MathModule.NO_ELEMENTS];
		MathModule mathModule = new MathModule(array);
		mathModule.populateArray(array);

		long startTime = System.currentTimeMillis();
		long sum = mathModule.computeSum(array);
		long stopTime = System.currentTimeMillis();
		System.out.println(
				String.format("The sum computed on the main is %d computed in %dms", sum, stopTime - startTime));

		final int NO_THREAD = 6;
		sum = 0;
		startTime = System.currentTimeMillis();

		SumThread[] threads = new SumThread[NO_THREAD];
		for (int i = 0; i < NO_THREAD; i++) {
			threads[i] = new SumThread(array, i * (MathModule.NO_ELEMENTS / NO_THREAD),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREAD));
			threads[i].start();
		}
		
		
		for(int i = 0;i<NO_THREAD; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		for (int i = 0; i < NO_THREAD; i++) {
			sum += threads[i].getSum();
		}
		
		stopTime = System.currentTimeMillis();
		System.out.println(
				String.format("The sum computed on the another thread is %d computed in %dms", sum, stopTime - startTime));
		
		
		sum = 0;
		startTime = System.currentTimeMillis();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(NO_THREAD);
		SumThread[] workers = new SumThread[NO_THREAD];
		for (int i = 0; i < NO_THREAD; i++) {
			workers[i] = new SumThread(array, i * (MathModule.NO_ELEMENTS / NO_THREAD),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREAD));
			threadPool.execute(workers[i]);
		}
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < NO_THREAD; i++) {
			sum += workers[i].getSum();
		}
		
		stopTime = System.currentTimeMillis();
		System.out.println(
				String.format("The sum computed on the another thread (thread pool) is %d computed in %dms", sum, stopTime - startTime));
		
		
		sum = 0;
		startTime = System.currentTimeMillis();
		
		ExecutorService callablePool = Executors.newFixedThreadPool(NO_THREAD);
		List<Future<Long>> results = new ArrayList<Future<Long>>();

		for (int i = 0; i < NO_THREAD; i++) {
			SumCallable callable = new SumCallable(array, i * (MathModule.NO_ELEMENTS / NO_THREAD),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREAD));
			Future<Long> promise = callablePool.submit(callable);
			results.add(promise);
		}
		callablePool.shutdown();
		
		for(Future<Long> p : results) {
			try {
				sum += p.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stopTime = System.currentTimeMillis();
		System.out.println(
				String.format("The sum computed on the callable thread pool is %d computed in %dms", sum, stopTime - startTime));
		
		

	}

}
