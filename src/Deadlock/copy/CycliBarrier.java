package Deadlock.copy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("SLEEP COMPLETE FOR 1");
				barrier.await();
				System.out.println("DO THE TASK FOR 1");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

		});

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(3000);
				System.out.println("SLEEP COMPLETE FOR 2");
				barrier.await();
				System.out.println("DO THE TASK FOR 2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		});

		Thread t3 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("SLEEP COMPLETE FOR 3");
				barrier.await();
				System.out.println("DO THE TASK FOR 3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}
