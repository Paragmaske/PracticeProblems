package Deadlock.copy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock3 {

	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				lock1.lock();
				System.out.println("acquiring lock1 ::" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
					innerMethod();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} finally {
				lock1.unlock();
			System.out.println("Outside method lock unlocked");
			}

		});

		
		t1.start();
	}

	private static void innerMethod() {
		try {
			System.out.println("Entering the lock inside");
			lock1.lock();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finally {
			lock1.unlock();
			System.out.println("unlock the lock inside");
		}
		
		
		
		
	}

}
