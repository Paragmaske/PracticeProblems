package Deadlock.copy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock2 {

	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				lock1.lock();
				System.out.println("acquiring lock1 ::" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					lock2.lock();
					System.out.println("acquiring lock2 ::" + Thread.currentThread().getName());
				} finally {
					lock2.unlock();
				}

			} finally {
				lock1.unlock();
			}

		});

		Thread t2 = new Thread(() -> {
			try {
				lock2.lock();
				System.out.println("acquiring lock2 ::" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					lock1.lock();
					System.out.println("acquiring lock2 ::" + Thread.currentThread().getName());
				} finally {
					lock1.unlock();
				}

			} finally {
				lock2.unlock();
			}

		});

		t1.start();
		t2.start();
	}
}
