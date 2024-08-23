package Deadlock.copy;

public class LockingOrdering {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("acquiring lock1 ::" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("acquiring lock2 ::" + Thread.currentThread().getName());

				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("acquiring lock1 ::" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("acquiring lock2 ::" + Thread.currentThread().getName());

				}
			}
		});

		t1.start();
		t2.start();
	}
}
