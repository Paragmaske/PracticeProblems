package Deadlock.copy;

public class PriortiyBlockingQueue implements Runnable, Comparable<PriortiyBlockingQueue> {

	private int priority;

	public PriortiyBlockingQueue(int priority) {
		this.priority = priority;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running with priority" + priority);
	}

	@Override
	public int compareTo(PriortiyBlockingQueue o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.priority, o.priority);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new PriortiyBlockingQueue(i));
			t.start();
		}
	}
}
