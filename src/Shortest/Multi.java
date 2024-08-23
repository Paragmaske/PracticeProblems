package Shortest;

public class Multi {
	volatile int count = 0;
	int maxCount = 10;

	synchronized void printFirst() {
		while (count < maxCount) {
			if (count % 3 == 0) {
				System.out.println(count +" "+ Thread.currentThread().getName());
			count++;
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
		}
	}

	synchronized void printSecond() {
		while (count < maxCount) {
			if (count % 3 == 1) {
			System.out.println(count +" "+ Thread.currentThread().getName());
			count++;

			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
		}
	}

	synchronized void printThird() {
		while (count < maxCount) {
			if (count % 3 == 2) {
				System.out.println(count +" " + Thread.currentThread().getName());
				count++;

			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
		}
	}

	public static void main(String[] args) {
		Multi m = new Multi();
		Thread t1 = new Thread(() -> {
			m.printFirst();
		});

		Thread t2 = new Thread(() -> {
			m.printSecond();
		});

		Thread t3 = new Thread(() -> {
			m.printThird();
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
