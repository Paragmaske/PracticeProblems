package Deadlock.copy;

import java.util.concurrent.locks.ReentrantLock;

public class Starvation {

	public static final ReentrantLock lock = new ReentrantLock();

	public static void print(String message) {

		try {
			lock.lock();
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> print("hello"));
		Thread t2 = new Thread(() -> print("bye"));
		t1.start();
		t2.start();
	}
}
